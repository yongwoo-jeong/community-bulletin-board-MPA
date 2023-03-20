package com.mpa.bbs.commands;

import com.mpa.bbs.controller.View;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 커맨드 인터페이스
 */
public interface Command {

	/**
	 * 실행 메서드
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 */
	View execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}
