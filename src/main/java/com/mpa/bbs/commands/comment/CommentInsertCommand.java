package com.mpa.bbs.commands.comment;

import com.mpa.bbs.commands.Command;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String boardType = request.getParameter("board");
		String articleId = request.getParameter("articleId");
	}
}
