package com.mpa.bbs.commands.user;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.View;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 로그인 GET 커맨드
 */
public class LoginFormCommand implements Command {

	/**
	 * 로그인 화면 리다이렉트
	 */
	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 로그인 후 리디션을 위해
		// form.jsp 페이지로 들어오기 이전 페이지 기억
		String prevPage = request.getHeader("referer");
		request.setAttribute("prevPage", prevPage);
		return new View("/loginForm.jsp");
	}
}
