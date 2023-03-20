package com.mpa.bbs.commands;

import com.mpa.bbs.controller.View;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorCommand implements Command {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) {
//		에러페이지
		return new View("/error.jsp");
	}
}
