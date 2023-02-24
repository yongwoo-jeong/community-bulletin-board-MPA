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
import version.mpa.bbs.commands.article.ArticleFormCommand;
import version.mpa.bbs.commands.article.ArticleInsertCommand;
import version.mpa.bbs.commands.article.NoticeCommand;
import version.mpa.bbs.commands.user.LoginCommand;
import version.mpa.bbs.commands.user.LoginFormCommand;
import version.mpa.bbs.commands.user.SignupCommand;
import version.mpa.bbs.commands.user.SignupFormCommand;

/**
 * 디스패쳐 서블릿
 */
@WebServlet(urlPatterns = {"/home", "/login", "/logout", "/signup", "/edit-profile", "/notice", "*.new"})
@AllArgsConstructor
public class FrontController extends HttpServlet {



	/**
	 * GET request uri 매핑
	 * @param request
	 * @return
	 */
	private Command getMapping(HttpServletRequest request) throws IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		if (Objects.equals(uri, URL.HOME.getUrlPath())) {
			return new HomeCommand();
		} else if (Objects.equals(uri, URL.SIGN_UP.getUrlPath())) {
			return new SignupFormCommand();
		} else if (Objects.equals(uri, URL.LOG_IN.getUrlPath())) {
			return new LoginFormCommand();
		} else if (Objects.equals(uri, URL.NOTICE.getUrlPath())) {
			return new NoticeCommand();
		} else if (Objects.equals(uri, URL.NOTICE.getUrlPath()+ URLAction.NEW.getActionUri())) {
			return new ArticleFormCommand();
		}
		return null;
	}

	/**
	 * POST request uri 매핑
	 */
	private Command postMapping(HttpServletRequest request){
		String uri = request.getRequestURI();
		if (Objects.equals(uri, URL.LOG_IN.getUrlPath())){
			return new LoginCommand();
		} else if (Objects.equals(uri, URL.SIGN_UP.getUrlPath())) {
			return new SignupCommand();
		} else if (Objects.equals(uri, URL.NOTICE.getUrlPath()+URLAction.NEW.getActionUri())) {
			return new ArticleInsertCommand();
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
		Command action = getMapping(request);
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command action = postMapping(request);
		if (action == null) {
			throw new RuntimeException("Invalid request");
		} else {
			action.execute(request, response);
		}
	}
}