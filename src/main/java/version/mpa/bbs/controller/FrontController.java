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
import version.mpa.bbs.service.UserService;
import version.mpa.bbs.util.StringUtil;
import version.mpa.bbs.vo.UserVO;

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
			if (Objects.equals(url, URLs.HOME.getUrl())) {
				homeController(request, response);
			}
			if (Objects.equals(url, URLs.LOGIN.getUrl())){
				new UserController().loginFormController(request, response);
			}
			if (Objects.equals(url, URLs.SIGN_UP.getUrl())){
				new UserController().signUpFormController(request, response);
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
		if (Objects.equals(url, URLs.SIGN_UP.getUrl())){
			new UserController().signUpController(request, response);
		}
		if (Objects.equals(url, URLs.LOGIN.getUrl())){
			new UserController().loginController(request, response);
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


}