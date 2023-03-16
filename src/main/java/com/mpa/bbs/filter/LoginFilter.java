package com.mpa.bbs.filter;

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
 * 캐릭터셋 인코딩
 */
@WebFilter(urlPatterns = {"/logout", "/edit-profile", "*.new"})
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		if (session == null){
//			세션 존재 X
		}
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		if (!isLogin){
//			로그인 되지 않은 상태
		}
		chain.doFilter(request, response);
	}
}
