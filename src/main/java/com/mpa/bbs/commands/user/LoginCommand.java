package com.mpa.bbs.commands.user;

import com.mpa.bbs.repository.UserRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.URL;
import com.mpa.bbs.error.LoginError;
import com.mpa.bbs.vo.UserVO;

/**
 * 로그인 처리 커맨드
 */
public class LoginCommand implements Command {

	/**
	 * 로그인 POST 요청 처리
	 * TODO 로그인 후 원래 있던 페이지로 이동
	 * TODO 로그인 후 새로고침
	 *
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws IOException
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorMessage = "errorMessage";
		request.getRequestDispatcher(URL.LOG_IN.getViewPath()).forward(request, response);
		String userInputAccount = request.getParameter("account");
		String userInputPassword = request.getParameter("password");
		UserVO targetUser = new UserRepository().selectUser(userInputAccount);
		if (!BCrypt.checkpw(userInputPassword, targetUser.getPassword())) {
			request.setAttribute(errorMessage, LoginError.INCORRECT_PASSWORD.getErrorMessage());
			response.sendError(400);
			return;
		}
		HttpSession loginSession = request.getSession();
		loginSession.setAttribute("loginAccount", targetUser.getAccount());
		loginSession.setAttribute("loginUsername", targetUser.getUserName());
		// 세션 유지 4시간
		loginSession.setMaxInactiveInterval(60*60*4);
		request.getRequestDispatcher(URL.HOME.getViewPath()).forward(request,response);
	}
}
