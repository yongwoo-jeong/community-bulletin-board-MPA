package com.mpa.bbs.commands.article;

import com.mpa.bbs.commands.Command;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 새 게시글 FORM
 */
public class ArticleFormCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/newArticle.jsp").forward(request,response);
	}
}
