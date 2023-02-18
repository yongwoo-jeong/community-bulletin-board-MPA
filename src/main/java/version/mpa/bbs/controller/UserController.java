package version.mpa.bbs.controller;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;
import version.mpa.bbs.enums.LoginError;
import version.mpa.bbs.enums.SignUpError;
import version.mpa.bbs.enums.URL;
import version.mpa.bbs.service.UserService;
import version.mpa.bbs.util.StringUtil;
import version.mpa.bbs.vo.UserVO;

/**
 * 회원 관련 요청 컨트롤러
 */
public class UserController {

	/**
	 * 뷰에 설정될 에러 Attribute name
	 */
	private final String errorMessage = "ERROR_MESSAGE";

	/**
	 * 로그인 페이지 GET 요청 처리
	 */
	protected void getLoginController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(URL.LOG_IN.getViewPath()).forward(request, response);
	}

	/**
	 * 로그인 POST 요청 처리
	 * TODO 로그인 후 원래 있던 페이지로 이동
	 * TODO 쿠키가 있어도 로그인 창 뜨는것 수정
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws IOException
	 */
	protected void postLoginController(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String userInputAccount = request.getParameter("account");
		String userInputPassword = request.getParameter("password");
		UserVO targetUser = new UserService().selectUser(userInputAccount);
		if (!BCrypt.checkpw(userInputPassword, targetUser.getPassword())){
			request.setAttribute(errorMessage, LoginError.INCORRECT_PASSWORD.getErrorMessage());
			response.sendError(400);
			return;
		}
		Cookie idCookie = new Cookie("loginAccount", targetUser.getAccount());
		idCookie.setMaxAge(2 * 60 * 60);
		response.addCookie(idCookie);
		request.getRequestDispatcher(URL.HOME.getViewPath()).forward(request,response);
	}

	/**
	 * 회원가입 GET 요청 처리
	 */
	protected void getSignUpController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(URL.SIGN_UP.getViewPath()).forward(request, response);
	}

	/**
	 * 회원가입 POST 요청 처리
	 * TODO 반복되는 ERROR_MESSAGE 어떻게 처리?
	 */
	protected void postSignUpController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String account = request.getParameter("account");
		// 알파벳 소문자, 숫자 5~9자
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

	/**
	 * 프로필 수정 페이지 GET 요청 컨트롤러
	 * 비밀번호 확인 후 처리
	 * @param request
	 * @param response
	 */
	protected void getEditProfileController(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String userAccount = request.getParameter("id");
		String inputPassword = request.getParameter("password");
		UserVO targetUser = new UserService().selectUser(userAccount);
		if (!BCrypt.checkpw(inputPassword, targetUser.getPassword())){
			request.setAttribute(errorMessage, LoginError.INCORRECT_PASSWORD.getErrorMessage());
			response.sendError(400);
			return;
		}
		request.getRequestDispatcher(URL.EDIT_PROFILE.getViewPath()).forward(request,response);
	}

	/**
	 * 로그아웃 컨트롤러
	 * @param request
	 * @param response
	 */
	protected void logOutController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = new Cookie("loginAccount", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		request.getRequestDispatcher(URL.HOME.getViewPath()).forward(request, response);

	}

}
