package com.mpa.bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Setter;

/**
 * 뷰렌더링을 위한 뷰 클래스
 */
@Setter
public class View {

	/**
	 * 리다이렉트 여부
	 */
	public Boolean isRedirect=false;
	/**
	 * 뷰패스(jsp 경로 혹은 url 경로-리다이렉트시)
	 */
	public String viewPath;

	/**
	 * 뷰패스만 받는 경우 생성자(리다이렉트 off)
	 * @param viewPath
	 */
	public View(String viewPath){
		this.viewPath = viewPath;
	}

	/**
	 * 뷰패스, 리다이렉트 여부 모두 받는 생성자
	 * @param viewPath
	 * @param isRedirect
	 */
	public View(String viewPath, Boolean isRedirect){
		this.viewPath = viewPath;
		this.isRedirect = isRedirect;
	}

	/**
	 * 렌더 메서드
	 * 리다이렉트 혹은 포워드
	 */
	public void render(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (Boolean.TRUE.equals(this.isRedirect)){
			response.sendRedirect(this.viewPath);
			return;
		}
		request.getRequestDispatcher(this.viewPath).forward(request,response);
	}

}
