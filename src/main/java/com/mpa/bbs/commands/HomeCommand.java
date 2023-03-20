package com.mpa.bbs.commands;

import com.mpa.bbs.controller.View;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 인덱스 페이지 뷰 커맨드
 */
public class HomeCommand implements Command {
	/**
	 * 메인화면(/) 컨트롤러 메서드
	 *
	 * @return
	 */
	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		return new View("/home.jsp");
	}
}
