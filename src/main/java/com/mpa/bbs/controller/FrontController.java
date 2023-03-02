package com.mpa.bbs.controller;

import com.mpa.bbs.commands.Command;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

/**
 * 디스패쳐 서블릿
 * TODO 리퀘스트 요청 매핑 방법.. controller -> command return ViewRenderer -> render() in controller?
 */
@WebServlet(urlPatterns = {"/home", "/login", "/logout", "/signup", "/edit-profile", "/notice", "/noticeDetail", "*.new"})
@AllArgsConstructor
public class FrontController extends HttpServlet {


	/**
	 * GET 요청과 컨트롤러 메서드 매칭
	 * TODO 매칭 방법, 예외처리.
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		Command action = URL.getCommandByUrl(uri);
		action.execute(request, response);
	}

	/**
	 * 포스트 요청 컨트롤러 매핑
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		Command action = URL.postCommandByUrl(uri);
		action.execute(request, response);
	}
}