package com.mpa.bbs.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 로그인 시 가능한 에러
 */
@Getter
@AllArgsConstructor
public enum LoginError {
	INVALID_ACCOUNT("존재하지 않는 계정입니다."),
	INCORRECT_PASSWORD("ID, 비밀번호가 일치하지 않습니다.");

	/**
	 * view 에 나타날 에러메세지
	 */
	private final String errorMessage;
}
