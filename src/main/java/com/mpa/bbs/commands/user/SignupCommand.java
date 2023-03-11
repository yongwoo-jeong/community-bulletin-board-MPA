package com.mpa.bbs.commands.user;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.URL;
import com.mpa.bbs.error.LoginError;
import com.mpa.bbs.error.SignUpError;
import com.mpa.bbs.service.UserService;
import com.mpa.bbs.vo.UserVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

/**
 * 회원가입 프로세스 처리 (POST)
 * TODO 반복되는 ERROR_MESSAGE 어떻게 처리?
 */
public class SignupCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 회원가입정보
		String account = request.getParameter("account");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
		UserVO newUser = UserVO.builder().account(account).password(password).userName(name).email(email).build();

		UserService userService = new UserService();
		SignUpError validation = userService.validate(newUser, passwordConfirm);
		if (validation != SignUpError.VALID){
			request.setAttribute("errorMessage", LoginError.INVALID_ACCOUNT.getErrorMessage());
			response.sendError(LoginError.INVALID_ACCOUNT.getHttpStatus());
			return;
		}
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		newUser.setPassword(hashedPassword);
		userService.insertUser(newUser);

		request.getRequestDispatcher(URL.HOME.getViewPath()).forward(request, response);

	}
}
