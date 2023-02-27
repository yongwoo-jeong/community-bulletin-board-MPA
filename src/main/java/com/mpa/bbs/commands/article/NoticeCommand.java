package com.mpa.bbs.commands.article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.URL;
import com.mpa.bbs.repository.ArticleRepository;
import com.mpa.bbs.vo.BoardType;

/**
 * 공지사항 게시글 리스트 커맨드
 */
public class NoticeCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("articleList", new ArticleRepository().selectArticleList(BoardType.NOTICE.getTableName(),0));
		request.getRequestDispatcher(URL.NOTICE.getViewPath()).forward(request,response);
	}
}
