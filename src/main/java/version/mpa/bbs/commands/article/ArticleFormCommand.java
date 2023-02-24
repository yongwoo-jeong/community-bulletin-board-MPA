package version.mpa.bbs.commands.article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import version.mpa.bbs.commands.Command;

public class ArticleFormCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/newArticle.jsp").forward(request,response);
	}
}
