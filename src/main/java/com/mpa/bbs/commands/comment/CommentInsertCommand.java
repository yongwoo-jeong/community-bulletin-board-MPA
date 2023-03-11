package com.mpa.bbs.commands.comment;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.error.LoginError;
import com.mpa.bbs.service.BoardType;
import com.mpa.bbs.service.CommentService;
import com.mpa.bbs.vo.CommentVO;
import com.mpa.bbs.vo.UserVO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserVO loginUser = (UserVO) request.getSession().getAttribute("loginUser");
		// 로그인되지 않은 경우 에러페이지
		if (loginUser==null){
			request.setAttribute("errorMessage", LoginError.NOT_LOGIN_USER.getErrorMessage());
			response.sendError(LoginError.NOT_LOGIN_USER.getHttpStatus());
			return;
		}

		// 게시판 id
		Integer boardId = Integer.valueOf(request.getParameter("board"));
		List<Integer> boardIdList = BoardType.getBoardIdList();
		// 게시판 id 가 이상할 경우 에러
		if (!boardIdList.contains(boardId)){
			response.sendError(403);
		}
		String boardType = BoardType.getConstantById(boardId).getCommentTable();
		Integer articleId = Integer.valueOf(request.getParameter("id"));
		String content = request.getParameter("content");
		String writer = request.getParameter("username");
		CommentVO newComment = CommentVO.builder().writer(writer).content(content).articleId(articleId).build();
		new CommentService().insert(boardType, newComment);
	}
}
