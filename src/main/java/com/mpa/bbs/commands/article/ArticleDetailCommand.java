package com.mpa.bbs.commands.article;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.URL;
import com.mpa.bbs.service.ArticleService;
import com.mpa.bbs.service.BoardType;
import com.mpa.bbs.service.CommentService;
import com.mpa.bbs.service.FileService;
import com.mpa.bbs.vo.ArticleVO;
import com.mpa.bbs.vo.CommentVO;
import com.mpa.bbs.vo.FileVO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 게시글 상세
 */
public class ArticleDetailCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer articleId = Integer.parseInt(request.getParameter("id"));
		ArticleVO targetArticle = new ArticleService().select(BoardType.NOTICE.getArticleTable(), articleId);
		List<FileVO> fileList = new FileService().selectFileList(BoardType.NOTICE.getFileTable(), articleId);
		List<CommentVO> commentList = new CommentService().selectCommentList(BoardType.NOTICE.getCommentTable(), articleId);
		request.setAttribute("targetArticle", targetArticle);
		request.setAttribute("fileList", fileList);
		request.setAttribute("commentList", commentList);
		request.getRequestDispatcher(URL.NOTICE_DETAIL.getViewPath()).forward(request, response);
	}
}
