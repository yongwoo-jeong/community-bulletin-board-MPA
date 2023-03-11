package com.mpa.bbs.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 로그인 시 가능한 에러
 */
@Getter
@AllArgsConstructor
public enum LoginError {

	NOT_LOGIN_USER("먼저 로그인해야합니다", 401),
	INVALID_ACCOUNT("존재하지 않는 계정입니다.", 401),
	INCORRECT_PASSWORD("ID, 비밀번호가 일치하지 않습니다.", 401);

	/**
	 * view 에 나타날 에러메세지
	 */
	private final String errorMessage;

	private final Integer httpStatus;

}
