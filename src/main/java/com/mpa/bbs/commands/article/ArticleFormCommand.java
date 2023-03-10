package com.mpa.bbs.commands.article;

import com.mpa.bbs.commands.Command;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * μ κ²μκΈ FORM
 */
public class ArticleFormCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession loginSession = request.getSession();
		loginSession.removeAttribute("loginAccount");
		request.getRequestDispatcher("/noticeForm.jsp").forward(request,response);
	}
}
