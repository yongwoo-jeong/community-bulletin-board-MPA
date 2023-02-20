package version.mpa.bbs.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import version.mpa.bbs.controller.URL;

/**
 * 인덱스 페이지 뷰 커맨드
 */
public class HomeCommand implements Command {
	/**
	 * 메인화면(/) 컨트롤러 메서드
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher(URL.HOME.getViewPath()).forward(request,response);
	}
}
