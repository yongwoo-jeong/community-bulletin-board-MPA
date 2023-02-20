package version.mpa.bbs.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import version.mpa.bbs.controller.URL;

public class HomeCommand implements Command {
	/**
	 * 메인화면(/) 컨트롤러 메서드
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestType = request.getMethod();
		System.out.println("Request type: " + requestType);
		request.getRequestDispatcher(URL.HOME.getViewPath()).forward(request, response);
	}
}
