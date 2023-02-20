package version.mpa.bbs.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import version.mpa.bbs.controller.URL;

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
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(URL.SIGN_UP.getViewPath()).forward(request,response);
	}
}
