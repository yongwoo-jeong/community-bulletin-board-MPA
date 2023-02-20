package version.mpa.bbs.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import version.mpa.bbs.controller.URL;

/**
 * 로그아웃 커맨드
 */
public class LogoutCommand implements Command {

	/**
	 * 세션 종료
	 * TODO 세션으로 변경,  뒤로가기 방지 위해 포워드가 아닌 리다이렉트로 수정
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = new Cookie("loginAccount", null);
		// 로그인 종료
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		request.getRequestDispatcher(URL.HOME.getViewPath()).forward(request, response);
	}

}
