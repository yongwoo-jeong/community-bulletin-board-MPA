package com.mpa.bbs.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ViewPath {
	HOME("/home.jsp"),

	LOG_IN("/loginForm.jsp"),

	SIGN_UP("/signupForm.jsp"),

	EDIT_PROFILE("/editProfile.jsp"),

	ERROR("/error.jsp"),

	ARTICLE_LIST("/articleList.jsp"),

	NEW_ARTICLE("/articleForm.jsp"),

	ARTICLE_DETAIL("/articleDetail.jsp");

	private final String jspPath;

}
