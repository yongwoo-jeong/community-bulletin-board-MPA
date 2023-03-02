package com.mpa.bbs.commands.article;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.URL;
import com.mpa.bbs.service.ArticleService;
import com.mpa.bbs.service.TableName;
import com.mpa.bbs.vo.ArticleVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArticleDetailCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer articleId = Integer.valueOf(request.getParameter("id"));
		ArticleVO targetArticle = new ArticleService().select(TableName.NOTICE.getArticleTable(),articleId);
		request.setAttribute("targetArticle", targetArticle);
		request.getRequestDispatcher(URL.ARTICLE_DETAIL.getViewPath()).forward(request, response);
	}
}
