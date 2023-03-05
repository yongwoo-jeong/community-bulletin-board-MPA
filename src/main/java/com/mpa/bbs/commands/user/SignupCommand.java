package com.mpa.bbs.commands.user;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.URL;
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
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");

		UserVO newUser = UserVO.builder().account(account).password(password).userName(name).email(email).build();
		UserService userService = new UserService();
		SignUpError validation = userService.validate(newUser, passwordConfirm);
		if (validation != SignUpError.VALID){
			response.sendError(validation.getHttpStatus(), validation.getErrorMessage());
			request.getRequestDispatcher(URL.ERROR.getViewPath()).forward(request,response);
			return;
		}
		String salt = BCrypt.gensalt();
		String hashedPassword = BCrypt.hashpw(password, salt);
		newUser.setPassword(hashedPassword);
		userService.insertUser(newUser);
		// 알파벳 소문자, 숫자 5~9자

		request.getRequestDispatcher(URL.HOME.getViewPath()).forward(request, response);

	}
}
