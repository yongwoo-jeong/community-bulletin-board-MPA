package version.mpa.bbs.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 로그인 시 가능한 에러
 */
@Getter
@AllArgsConstructor
public enum LoginError {
	INCORRECT_PASSWORD("ID, 비밀번호가 일치하지 않습니다.");

	/**
	 * view 에 나타날 에러메세지
	 */
	private final String errorMessage;
}
