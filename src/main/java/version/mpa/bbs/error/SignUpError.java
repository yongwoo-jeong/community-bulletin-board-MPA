package version.mpa.bbs.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 회원가입 시 가능한 에러
 */
@Getter
@AllArgsConstructor
public enum SignUpError {
	ACCOUNT("제출된 ID 형식이 올바르지 않습니다."),
	ACCOUNT_EXISTS("이미 존재하는 ID 입니다."),
	PASSWORD("제출된 비밀번호 형식이 올바르지 않습니다."),
	PASSWORD_CONFIRM("제출된 비밀번호 확인 형식이 올바르지 않습니다."),
	PASSWORD_NOT_MATCH("비밀번호-확인이 일치하지 않습니다."),
	NAME("제출된 이름 형식이 올바르지 않습니다."),
	EMAIL("제출된 이메일 형식이 올바르지 않습니다.");

	/**
	 * view 에 나타날 에러메세지
	 */
	private final String errorMessage;

}
