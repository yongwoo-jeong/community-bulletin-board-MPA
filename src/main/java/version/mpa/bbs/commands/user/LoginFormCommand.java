package version.mpa.bbs.commands.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import version.mpa.bbs.commands.Command;
import version.mpa.bbs.controller.URL;

/**
 * 로그인 GET 커맨드
 */
public class LoginFormCommand implements Command {

	/**
	 * 로그인 화면 리다이렉트
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher(URL.LOG_IN.getViewPath()).forward(request,response);
	}
}
