package version.mpa.bbs.controller;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet dispatcher getting all the Request from client.
 */
@WebServlet("/")
@AllArgsConstructor
public class FrontController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			String url = request.getRequestURI();
			System.out.println("get REQ");
			System.out.println(url);
			if (Objects.equals(url, URLs.HOME.getUrl())) {
				homeController(request, response);
			}
			if (Objects.equals(url, URLs.LOGIN.getUrl())){
				loginFormController(request, response);
			}
			if (Objects.equals(url, URLs.SIGN_UP.getUrl())){
				signUpFormController(request, response);
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

		switch (url) {
			case "/signup":
				postSignUpController(request, response);
				break;
			default:
				return;
		}
	}

	/**
	 * 메인화면(/) 컨트롤러 메서드
	 */
	private void homeController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	/**
	 * 게시글 상세 컨트롤러 메서드
	 */
	private void articleDetailController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/articleDetail.jsp").forward(request, response);

	}

	/**
	 * 로그인 페이지 컨트롤러 메서드
	 */
	private void loginFormController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/loginForm.jsp").forward(request, response);
	}

	/**
	 * 회원가입 GET 컨트롤러 메서드
	 */
	private void signUpFormController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/signUp.jsp").forward(request, response);
	}

	/**
	 * 회원가입 POST 컨트롤러 메서드
	 */
	private void postSignUpController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("account"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("passwordConfirm"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("email"));
		request.getRequestDispatcher("/signUp.jsp").forward(request, response);
	}

	/**
	 * 로그인 컨트롤러 메서드
	 */
	private void signInController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		패스워드 일치 여부 확인
		String hashed = BCrypt.hashpw("1224", BCrypt.gensalt());
		if (BCrypt.checkpw("124", hashed)) {
		}
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}
}