package com.mpa.bbs.commands.comment;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.URL;
import com.mpa.bbs.service.CommentService;
import com.mpa.bbs.service.BoardType;
import com.mpa.bbs.vo.CommentVO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer boardId = Integer.valueOf(request.getParameter("board"));
		List<Integer> boardIdList = BoardType.getBoardIdList();
		if (!boardIdList.contains(boardId)){
			response.sendRedirect(URL.ERROR.getUrlPath());
		}
		String boardType = BoardType.getConstantById(boardId).getCommentTable();
		Integer articleId = Integer.valueOf(request.getParameter("id"));
		String content = request.getParameter("content");
		String writer = request.getParameter("username");
		CommentVO newComment = CommentVO.builder().writer(writer).content(content).articleId(articleId).build();
		new CommentService().insert(boardType, newComment);

	}
}
