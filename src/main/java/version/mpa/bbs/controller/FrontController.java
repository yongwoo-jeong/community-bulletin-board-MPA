package version.mpa.bbs.controller;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import version.mpa.bbs.commands.Command;
import version.mpa.bbs.commands.HomeCommand;
import version.mpa.bbs.commands.LoginCommand;
import version.mpa.bbs.commands.SignupCommand;

/**
 * 디스패쳐 서블릿
 */
@WebServlet(urlPatterns = {"/home", "/login", "/logout", "/signup", "/edit-profile"})
@AllArgsConstructor
public class FrontController extends HttpServlet {


	private Command commandMapping(HttpServletRequest request) {
		String uri = request.getRequestURI();
		if (Objects.equals(uri, URL.HOME.getUrlPath())) {
			return new HomeCommand();
		} else if (Objects.equals(uri, URL.SIGN_UP.getUrlPath())) {
			return new SignupCommand();
		} else if (Objects.equals(uri, URL.LOG_IN.getUrlPath())) {
			return new LoginCommand();
		}
		return null;
	}

	/**
	 * GET 요청과 컨트롤러 메서드 매칭
	 * TODO 매칭 방법, 예외처리.
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command action = commandMapping(request);
		if (action == null) {
			throw new RuntimeException("Invalid request");
		} else {
			action.execute(request, response);
		}
	}

	/**
	 * 포스트 요청 컨트롤러 매핑
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
//
	}
}