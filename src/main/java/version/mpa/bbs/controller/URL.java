package version.mpa.bbs.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * URL 경로 명세
 */
@Getter
@AllArgsConstructor
public enum URL {
	HOME("/home", "/home.jsp"),
	LOG_IN("/login", "/loginForm.jsp"),
	LOG_OUT("/logout", ""),
	SIGN_UP("/signup", "/signUp.jsp"),
	EDIT_PROFILE("/edit-profile", "/editProfile.jsp"),
	ERROR("/error", "/error.jsp");

	/**
	 * URL 주소
	 */
	private final String urlPath;

	/**
	 * view path
	 */
	private final String viewPath;

}
