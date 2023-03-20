package com.mpa.bbs.filter;

import com.mpa.bbs.controller.ViewPath;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 로그인 세션 확인 필터
 */
@WebFilter(urlPatterns = {"/logout", "/edit-profile", "*.new"})
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		if (session == null){
			req.getRequestDispatcher(ViewPath.LOG_IN.getJspPath()).forward(request, response);
		}
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		if (Boolean.FALSE.equals(isLogin)){
			req.getRequestDispatcher(ViewPath.LOG_IN.getJspPath()).forward(request, response);
		}
		// TODO: 2023/03/17 에외 핸들러 어떻게 구성할지?
		chain.doFilter(request, response);
	}
}
