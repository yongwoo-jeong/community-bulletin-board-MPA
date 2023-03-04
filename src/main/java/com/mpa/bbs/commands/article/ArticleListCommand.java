package com.mpa.bbs.commands.article;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.URL;
import com.mpa.bbs.service.ArticleService;
import com.mpa.bbs.service.FileService;
import com.mpa.bbs.service.TableName;
import com.mpa.bbs.util.StringUtil;
import com.mpa.bbs.vo.ArticleVO;
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
		FileService fileService = new FileService();
		// 게시글 수
		Integer articleCount = articleService.selectCount(tableName, searchCriteria);
		// 게시글 리스트
		List<ArticleVO> articleList = articleService.selectList(tableName, searchCriteria);
		// 현재 페이지 게시글 ID 최댓값
		Integer maxId = articleList.stream().map(ArticleVO::getId).max(Integer::compareTo).orElse(0);
		// 현재 페이지 게시글 ID 최솟값
		Integer minId = articleList.stream().map(ArticleVO::getId).min(Integer::compareTo).orElse(0);
		// 파일이 첨부된 게시글 ID 리스트
		List<Integer> articleListFileAttached = fileService.selectIsFileAttached(TableName.NOTICE.getFileTable(), TableName.NOTICE.getArticleTable(), minId, maxId);
		request.setAttribute("articleCount", articleCount);
		request.setAttribute("articleList", articleList);
		request.setAttribute("articleListFileAttached", articleListFileAttached);
		request.setAttribute("currentPage", searchCriteria.getCurrentPage());
		request.getRequestDispatcher(URL.NOTICE.getViewPath()).forward(request, response);
	}
}
