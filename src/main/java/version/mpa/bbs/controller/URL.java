package version.mpa.bbs.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * URL 경로 명세
 */
@Getter
@AllArgsConstructor
public enum URL {
	/**
	 * GET 요청만 존재
	 */
	HOME("/home", "/home.jsp"),

	/**
	 * GET POST 존재
	 */
	LOG_IN("/login", "/loginForm.jsp"),

	/**
	 * ONLY POST
	 */
	LOG_OUT("/logout", ""),

	/**
	 * GET POST 존재
	 */
	SIGN_UP("/signup", "/signUp.jsp"),

	/**
	 * GET POST 존재
	 */
	EDIT_PROFILE("/edit-profile", "/editProfile.jsp"),

	/**
	 * ONLY GET
	 */
	ERROR("/error", "/error.jsp"),

	NOTICE("/notice", "/notice.jsp");

	/**
	 * URL 주소
	 */
	private final String urlPath;

	/**
	 * view path
	 */
	private final String viewPath;

}
