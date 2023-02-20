package version.mpa.bbs.commands;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;
import version.mpa.bbs.controller.URL;
import version.mpa.bbs.error.SignUpError;
import version.mpa.bbs.service.UserService;
import version.mpa.bbs.util.StringUtil;
import version.mpa.bbs.vo.UserVO;

/**
 * 회원가입 프로세스 처리 (POST)
 * TODO 반복되는 ERROR_MESSAGE 어떻게 처리?
 */
public class SignupCommand implements Command {

	/**
	 * 회원가입에 필요한 정보 검증 서비스로 넘겨주기
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorMessage = "errorMessage";
		String account = request.getParameter("account");
		// 알파벳 소문자, 숫자 5~9자
		/**
		 * 뷰에 설정될 에러 Attribute name
		 */
		if (!Pattern.matches("^[a-z0-9]{5,9}$",account)){
			request.setAttribute(errorMessage, SignUpError.ACCOUNT.getErrorMessage());
			response.sendError(422);
		}
		// 아이디 중복 체크
		if (new UserService().selectUser(account)!=null){
			request.setAttribute(errorMessage, SignUpError.ACCOUNT_EXISTS.getErrorMessage());
			response.sendError(422);
		}
		// 특수문자, 소문자, 숫자 6~ 15자
		String password =request.getParameter("password");
		if (!Pattern.matches("^[a-z0-9`~!@#$%^&*()-_=+]{6,15}$", password)){
			request.setAttribute(errorMessage, SignUpError.PASSWORD.getErrorMessage());
			response.sendError(422);
		}
		String passwordConfirm = request.getParameter("passwordConfirm");
		if (!Pattern.matches("^[a-z0-9`~!@#$%^&*()-_=+]{6,15}$", passwordConfirm)){
			request.setAttribute(errorMessage, SignUpError.PASSWORD_CONFIRM.getErrorMessage());
			response.sendError(422);
		}
		// 비밀번호, 비밀번호 확인 일치
		if (Boolean.FALSE.equals(StringUtil.isStringMatch(password, passwordConfirm))){
			request.setAttribute(errorMessage, SignUpError.PASSWORD_NOT_MATCH.getErrorMessage());
			response.sendError(422);
		}
		//한글 3,4자
		String name = request.getParameter("name");
		if (!Pattern.matches("^[ㄱ-ㅎ|가-힣]{3,4}$", name)){
			request.setAttribute(errorMessage, SignUpError.NAME.getErrorMessage());
			response.sendError(422);
		}
		// 이메일 형식
		String email = request.getParameter("email");
		if (!Pattern.matches("^[-0-9A-Za-z!#$%&'*+/=?^_`{|}~.]+@[-0-9A-Za-z!#$%&'*+/=?^_`{|}~]+[.][0-9A-Za-z]", email)){
			request.setAttribute(errorMessage, SignUpError.EMAIL.getErrorMessage());
			response.sendError(422);
		}

		UserVO newUser = UserVO.builder().account(account).password(BCrypt.hashpw(password, BCrypt.gensalt())).userName(name).email(email).build();
		new UserService().insertUser(newUser);
		request.getRequestDispatcher(URL.HOME.getViewPath()).forward(request, response);

	}
}
