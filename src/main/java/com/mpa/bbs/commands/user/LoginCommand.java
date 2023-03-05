package com.mpa.bbs.commands.user;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.controller.URL;
import com.mpa.bbs.error.LoginError;
import com.mpa.bbs.service.UserService;
import com.mpa.bbs.util.StringUtil;
import com.mpa.bbs.vo.UserVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

/**
 * 로그인 처리 커맨드
 */
public class LoginCommand implements Command {

	/**
	 * 로그인 POST 요청 처리
	 * TODO 로그인 후 원래 있던 페이지로 이동
	 * TODO 로그인 후 새로고침
	 *
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws IOException
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userInputAccount = request.getParameter("account");
		String userInputPassword = request.getParameter("password");
		UserVO targetUser = new UserService().selectUser(userInputAccount);

		// 로그인 실패 로직
		String errorMessage = "errorMessage";
		if (targetUser == null){
			request.setAttribute(errorMessage, LoginError.INVALID_ACCOUNT.getErrorMessage());
			response.sendError(400);
			return;
		}
		if (!BCrypt.checkpw(userInputPassword, targetUser.getPassword())) {
			request.setAttribute(errorMessage, LoginError.INCORRECT_PASSWORD.getErrorMessage());
			response.sendError(400);
			return;
		}

		// 로그인 성공 시 세션 생성
		HttpSession loginSession = request.getSession();
		loginSession.setAttribute("loginAccount", targetUser.getAccount());
		loginSession.setAttribute("loginUsername", targetUser.getUserName());
		loginSession.setMaxInactiveInterval(60*60*4);

		// 로그인 성공 이후 이전 페이지로 되돌려보내기
		String prevPage = request.getParameter("prevPage");
		if (StringUtil.isEmpty(prevPage) || "null".equals(prevPage)){
			response.sendRedirect(URL.HOME.getUrlPath());
			return;
		}
		response.sendRedirect(prevPage);
	}
}
