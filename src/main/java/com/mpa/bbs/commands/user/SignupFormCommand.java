package com.mpa.bbs.commands.user;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.View;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 회원가입 GET 요청 커맨드
 */
public class SignupFormCommand implements Command {

	/**
	 * 사인업 jsp 포워드
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return new View("/signupForm.jsp");
	}
}
