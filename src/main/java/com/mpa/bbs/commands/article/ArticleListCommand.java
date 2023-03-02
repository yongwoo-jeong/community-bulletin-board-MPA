package com.mpa.bbs.commands.article;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.URL;
import com.mpa.bbs.service.ArticleService;
import com.mpa.bbs.util.StringUtil;
import com.mpa.bbs.vo.ArticleVO;
import com.mpa.bbs.service.TableName;
import com.mpa.bbs.vo.SearchVO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 공지사항 게시글 리스트 커맨드
 */
public class ArticleListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String boardId = request.getParameter("boardId");
		String tableName = TableName.NOTICE.getArticleTable();

		SearchVO searchCriteria = SearchVO.builder().build();
		String keyword = request.getParameter("keyword");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String currentPage = request.getParameter("currentPage");
		Integer parsedCurrentPage = null;
		if (!StringUtil.isEmpty(currentPage)) {
			parsedCurrentPage = Integer.parseInt(currentPage);
			searchCriteria.setCurrentPage(parsedCurrentPage);
			searchCriteria.setDbLimitOffset((parsedCurrentPage-1)*10);
		}


		ArticleService articleService = new ArticleService();
		Integer articleCount = articleService.selectCount(tableName, searchCriteria);
		List<ArticleVO> articleList = articleService.selectList(tableName, searchCriteria);
		request.setAttribute("articleCount", articleCount);
		request.setAttribute("articleList", articleList);
		request.setAttribute("currentPage", searchCriteria.getCurrentPage());
		request.getRequestDispatcher(URL.NOTICE.getViewPath()).forward(request, response);
	}
}
