package com.mpa.bbs.commands.article;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.View;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 새 게시글 FORM
 */
public class ArticleFormCommand implements Command {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession loginSession = request.getSession();
		loginSession.removeAttribute("loginAccount");
		return new View("/noticeForm.jsp");
	}
}
