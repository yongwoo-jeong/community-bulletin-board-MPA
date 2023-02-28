package com.mpa.bbs.commands.article;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.URL;
import com.mpa.bbs.service.ArticleService;
import com.mpa.bbs.vo.ArticleVO;
import com.mpa.bbs.vo.BoardType;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 공지사항 게시글 리스트 커맨드
 */
public class NoticeCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ArticleVO> articleList = new ArticleService().selectArticleList(BoardType.NOTICE.getTableName(),0);
		request.setAttribute("articleList", articleList);
		request.getRequestDispatcher(URL.NOTICE.getViewPath()).forward(request,response);
	}
}
