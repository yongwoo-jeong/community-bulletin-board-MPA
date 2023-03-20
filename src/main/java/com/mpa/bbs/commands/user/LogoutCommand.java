package com.mpa.bbs.commands.user;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.View;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 로그아웃 커맨드
 */
public class LogoutCommand implements Command {

	/**
	 * 세션 종료
	 * TODO 세션으로 변경,  뒤로가기 방지 위해 포워드가 아닌 리다이렉트로 수정
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession loginSession = request.getSession();
		loginSession.removeAttribute("loginAccount");
		loginSession.removeAttribute("loginUsername");
		String prevPage = request.getHeader("referer");
		return new View(prevPage, true);
	}
}
