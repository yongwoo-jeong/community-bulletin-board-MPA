package version.mpa.bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;
import version.mpa.bbs.service.UserService;
import version.mpa.bbs.util.StringUtil;
import version.mpa.bbs.vo.UserVO;

public class UserController {
	/**
	 * 로그인 페이지 컨트롤러 메서드
	 */
	protected void loginFormController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(URL.LOGIN.getViewPath()).forward(request, response);
	}

	protected void loginController(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		new UserService().userLogin(request.getParameter("account"), request.getParameter("password"));
	}

	/**
	 * 회원가입 GET 컨트롤러 메서드
	 */
	protected void signUpFormController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(URL.SIGNUP.getViewPath()).forward(request, response);
	}

	/**
	 * 회원가입 POST 컨트롤러 메서드
	 */
	protected void signUpController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String account = request.getParameter("account");
		String password = BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt());
		String passwordConfirm = request.getParameter("passwordConfirm");
		if (Boolean.FALSE.equals(StringUtil.isStringMatch(password, passwordConfirm))){
			request.getRequestDispatcher("/signUp.jsp").forward(request, response);
			return;
		}
		String name = request.getParameter("name");
		String email = request.getParameter("email");
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
