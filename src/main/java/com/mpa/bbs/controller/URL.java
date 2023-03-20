package com.mpa.bbs.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 전체 사이트 URL
 */
@Getter
@AllArgsConstructor
public enum URL {

	HOME("/home"),
	SIGNUP("/signup"),
	LOGIN("/login"),
	LOGOUT("/logout"),
	EDIT_PROFILE("/edit-profile"),
	NOTICE("/notice"),
	NEW_NOTICE("/notice.new"),
	EDIT_NOTICE("/notice.edit"),
	NOTICE_DETAIL("/noticeDetail"),
	FILE_DOWNLOAD("/download"),
	NEW_COMMENT("/comment.new");

	private String url;
}
