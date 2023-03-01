package com.mpa.bbs.controller;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.commands.ErrorCommand;
import com.mpa.bbs.commands.HomeCommand;
import com.mpa.bbs.commands.article.ArticleListCommand;
import com.mpa.bbs.commands.user.LoginCommand;
import com.mpa.bbs.commands.user.LoginFormCommand;
import com.mpa.bbs.commands.user.LogoutCommand;
import com.mpa.bbs.commands.user.SignupCommand;
import com.mpa.bbs.commands.user.SignupFormCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * URL 경로 명세
 * TODO 상수에 할당된 커맨드 필드들은 전부 같은 인스턴스 반환.. 실제 스프링부트에선 개별 인스턴스 반환
 * TODO HomeCommand.class 식으로 등록하고 getCommand 메서드에서 newInstance로 반환하는 방법?
 */
@Getter
@AllArgsConstructor
public enum URL {
	/**
	 * GET 요청만 존재
	 */
	HOME("/home", "/home.jsp", new HomeCommand(), new ErrorCommand()),

	/**
	 * GET POST 존재
	 */
	LOG_IN("/login", "/loginForm.jsp", new LoginFormCommand(), new LoginCommand()),

	/**
	 * ONLY POST
	 */
	LOG_OUT("/logout", "", new ErrorCommand(), new LogoutCommand()),

	/**
	 * GET POST 존재
	 */
	SIGN_UP("/signup", "/signUp.jsp", new SignupFormCommand(), new SignupCommand()),

	/**
	 * GET POST 존재
	 */
	EDIT_PROFILE("/edit-profile", "/editProfile.jsp", new ErrorCommand(), new ErrorCommand()),

	/**
	 * ONLY GET
	 */
	ERROR("/error", "/error.jsp", new HomeCommand(), new ErrorCommand()),

	/**
	 * ONLY GET
	 */
	NOTICE("/notice", "/articleList.jsp", new ArticleListCommand(), new ErrorCommand());

	/**
	 * URL 주소
	 */
	private final String urlPath;

	/**
	 * view path
	 */
	private final String viewPath;

	private final Command getCommand;
	private final Command postCommand;

	public static Command getCommandByUrl(String requestedUrl) {
		for (URL urlValue : URL.values()) {
			if (urlValue.getUrlPath().equals(requestedUrl)) {
				return urlValue.getCommand;
			}
		}
		return null;
	}

	public static Command postCommandByUrl(String requestedUrl) {
		for (URL urlValue : URL.values()) {
			if (urlValue.getUrlPath().equals(requestedUrl)) {
				return urlValue.getCommand;
			}
		}
		return null;
	}


}
