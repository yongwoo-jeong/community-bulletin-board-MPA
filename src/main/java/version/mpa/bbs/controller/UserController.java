package version.mpa.bbs.controller;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;
import version.mpa.bbs.service.UserService;
import version.mpa.bbs.util.StringUtil;
import version.mpa.bbs.vo.UserVO;

/**
 * 회원 관련 요청 컨트롤러
 */
public class UserController {
	/**
	 * 로그인 페이지 GET 요청 처리
	 */
	protected void loginFormController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(URL.LOG_IN.getViewPath()).forward(request, response);
	}

	/**
	 * 로그인 POST 요청 처리
	 * TODO 로그인상태유지) 쿠키 추가
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	protected void loginController(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		new UserService().userLogin(request.getParameter("account"), request.getParameter("password"));
	}

	/**
	 * 회원가입 GET 요청 처리
	 */
	protected void signUpFormController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(URL.SIGN_UP.getViewPath()).forward(request, response);
	}

	/**
	 * 회원가입 POST GET 요청 처리
	 * TODO 반복되는 "errorMessage" 어떻게 처리?
	 */
	protected void signUpController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String account = request.getParameter("account");
		if (!Pattern.matches("^[a-z0-9]{5,9}$",account)){
			request.setAttribute("errorMessage", formValidMessage.ACCOUNT.getErrorMessage());
			response.sendError(422);
		}
		String password = BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt());
		if (!Pattern.matches("^[a-z0-9`~!@#$%^&*()-_=+]{6,15}$", password)){
			request.setAttribute("errorMessage", formValidMessage.PASSWORD.getErrorMessage());
			response.sendError(422);
		}
		String passwordConfirm = request.getParameter("passwordConfirm");
		if (!Pattern.matches("^[a-z0-9`~!@#$%^&*()-_=+]{6,15}$", passwordConfirm)){
			request.setAttribute("errorMessage", formValidMessage.PASSWORD_CONFIRM.getErrorMessage());
			response.sendError(422);
		}
		if (Boolean.FALSE.equals(StringUtil.isStringMatch(password, passwordConfirm))){
			request.setAttribute("errorMessage", formValidMessage.PASSWORD_NOT_MATCH.getErrorMessage());
			response.sendError(422);
		}
		String name = request.getParameter("name");
		if (!Pattern.matches("^[ㄱ-ㅎ|가-힣]{3,4}$", name)){
			request.setAttribute("errorMessage", formValidMessage.NAME.getErrorMessage());
			response.sendError(422);
		}
		String email = request.getParameter("email");
		if (!Pattern.matches("^[-0-9A-Za-z!#$%&'*+/=?^_`{|}~.]+@[-0-9A-Za-z!#$%&'*+/=?^_`{|}~]+[.][0-9A-Za-z]", email)){
			request.setAttribute("errorMessage", formValidMessage.EMAIL.getErrorMessage());
			response.sendError(422);
		}
		UserVO newUser = UserVO.builder().account(account).password(password).userName(name).email(email).build();
		new UserService().insertUser(newUser);
		request.getRequestDispatcher("/signUp.jsp").forward(request, response);
	}

	/**
	 * 로그인 컨트롤러 메서드
	 */
	private void signInController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		패스워드 일치 여부 확인
		String hashed = BCrypt.hashpw("1224", BCrypt.gensalt());
		if (BCrypt.checkpw("124", hashed)) {
		}
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

}
