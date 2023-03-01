package com.mpa.bbs.controller;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.commands.article.ArticleInsertCommand;
import com.mpa.bbs.commands.article.ArticleListCommand;
import com.mpa.bbs.commands.user.LoginCommand;
import com.mpa.bbs.commands.user.LoginFormCommand;
import com.mpa.bbs.commands.user.SignupFormCommand;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import com.mpa.bbs.commands.HomeCommand;
import com.mpa.bbs.commands.article.ArticleFormCommand;
import com.mpa.bbs.commands.user.SignupCommand;

/**
 * 디스패쳐 서블릿
 * TODO 리퀘스트 요청 매핑 방법.. controller -> command return ViewRenderer -> render() in controller?
 */
@WebServlet(urlPatterns = {"/home", "/login", "/logout", "/signup", "/edit-profile", "/notice", "*.new"})
@AllArgsConstructor
public class FrontController extends HttpServlet {
	/**
	 * GET request uri 매핑
	 * @param request
	 * @return
	 */
	private Command getMapping(HttpServletRequest request) throws IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		if (Objects.equals(uri, URL.HOME.getUrlPath())) {
			return new HomeCommand();
		} else if (Objects.equals(uri, URL.SIGN_UP.getUrlPath())) {
			return new SignupFormCommand();
		} else if (Objects.equals(uri, URL.LOG_IN.getUrlPath())) {
			return new LoginFormCommand();
		} else if (Objects.equals(uri, URL.NOTICE.getUrlPath())) {
			return new ArticleListCommand();
		} else if (Objects.equals(uri, URL.NOTICE.getUrlPath()+ URLAction.NEW.getActionUri())) {
			return new ArticleFormCommand();
		}
		return null;
	}

	/**
	 * POST request uri 매핑
	 */
	private Command postMapping(HttpServletRequest request){
		String uri = request.getRequestURI();
		if (Objects.equals(uri, URL.LOG_IN.getUrlPath())){
			return new LoginCommand();
		} else if (Objects.equals(uri, URL.SIGN_UP.getUrlPath())) {
			return new SignupCommand();
		} else if (Objects.equals(uri, URL.NOTICE.getUrlPath()+URLAction.NEW.getActionUri())) {
			return new ArticleInsertCommand();
		}
		return null;
	}

	/**
	 * GET 요청과 컨트롤러 메서드 매칭
	 * TODO 매칭 방법, 예외처리.
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command action = getMapping(request);
		if (action == null) {
			throw new RuntimeException("Invalid request");
		} else {
			action.execute(request, response);
		}
	}

	/**
	 * 포스트 요청 컨트롤러 매핑
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command action = postMapping(request);
		if (action == null) {
			throw new RuntimeException("Invalid request");
		} else {
			action.execute(request, response);
		}
	}
}