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
 * Servlet dispatcher getting all the Request from client.
 *
 */
@WebServlet(urlPatterns = {"/home", "/login", "/signup"} )
@AllArgsConstructor
public class FrontController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			String url = request.getRequestURI();
			System.out.println("get REQ");
			System.out.println(url);
			if (Objects.equals(url, URL.HOME.getUrlPath())) {
				homeController(request, response);
			}
			if (Objects.equals(url, URL.LOG_IN.getUrlPath())){
				new UserController().loginFormController(request, response);
			}
			if (Objects.equals(url, URL.SIGN_UP.getUrlPath())){
				new UserController().getSignUpController(request, response);
			}

		} catch (ServletException | IOException error) {
			request.setAttribute("error", error);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		System.out.println("POST REQ");
		System.out.println(url);
		if (Objects.equals(url, URL.SIGN_UP.getUrlPath())){
			new UserController().postSignUpController(request, response);
		}
		if (Objects.equals(url, URL.LOG_IN.getUrlPath())){
			new UserController().loginController(request, response);
		}
	}

	/**
	 * 메인화면(/) 컨트롤러 메서드
	 */
	private void homeController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(URL.HOME.getViewPath()).forward(request, response);
	}

	/**
	 * 게시글 상세 컨트롤러 메서드
	 */
	private void articleDetailController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/articleDetail.jsp").forward(request, response);

	}


}