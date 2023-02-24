package version.mpa.bbs.commands.article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import version.mpa.bbs.commands.Command;
import version.mpa.bbs.controller.URL;

/**
 * 공지사항 게시글 리스트 커맨드
 */
public class NoticeCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(URL.NOTICE.getViewPath()).forward(request,response);
	}
}
