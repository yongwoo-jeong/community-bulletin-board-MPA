package version.mpa.bbs.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;
import version.mpa.bbs.controller.URL;
import version.mpa.bbs.error.LoginError;
import version.mpa.bbs.service.UserService;
import version.mpa.bbs.vo.UserVO;

/**
 * 로그인 페이지 GET 요청 처리
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
		UserVO targetUser = new UserService().selectUser(userInputAccount);
		if (!BCrypt.checkpw(userInputPassword, targetUser.getPassword())) {
			request.setAttribute(errorMessage, LoginError.INCORRECT_PASSWORD.getErrorMessage());
			response.sendError(400);
			return;
		}
		Cookie idCookie = new Cookie("loginAccount", targetUser.getAccount());
		idCookie.setMaxAge(2 * 60 * 60);
		response.addCookie(idCookie);
		request.getRequestDispatcher(URL.HOME.getViewPath()).forward(request, response);
	}
}
