package version.mpa.bbs.controller;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

/**
 * 디스패쳐 서블릿
 *
 */
@WebServlet(urlPatterns = {"/home", "/login", "/logout", "/signup", "/edit-profile"} )
@AllArgsConstructor
public class FrontController extends HttpServlet {

	/**
	 * GET 요청과 컨트롤러 메서드 매칭
	 * TODO 매칭 방법, 예외처리.
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		String url = request.getRequestURI();

		try {
			if (Objects.equals(url, URL.HOME.getUrlPath())) {
				homeController(request, response);
			}
			if (Objects.equals(url, URL.LOG_IN.getUrlPath())){
				new UserController().getLoginController(request, response);
			}
			if (Objects.equals(url, URL.SIGN_UP.getUrlPath())){
				new UserController().getSignUpController(request, response);
			}
			if (Objects.equals(url, URL.LOG_OUT.getUrlPath())){
				new UserController().logOutController(request, response);
			}
			if (Objects.equals(url, URL.EDIT_PROFILE.getUrlPath())){
				new UserController().getEditProfileController(request, response);
			}
		} catch (ServletException | IOException error) {
			request.setAttribute("errorMessage", error);
		}
	}

	/**
	 * 포스트 요청 컨트롤러 매핑
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		String url = request.getRequestURI();
		try{
			if (Objects.equals(url, URL.SIGN_UP.getUrlPath())){
				new UserController().postSignUpController(request, response);
			}
			if (Objects.equals(url, URL.LOG_IN.getUrlPath())){
				new UserController().postLoginController(request, response);
			}
		} catch (ServletException | IOException error) {
			request.setAttribute("errorMessage", error);
		}
	}

	/**
	 * 메인화면(/) 컨트롤러 메서드
	 */
	private void homeController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(URL.HOME.getViewPath()).forward(request, response);
	}

}