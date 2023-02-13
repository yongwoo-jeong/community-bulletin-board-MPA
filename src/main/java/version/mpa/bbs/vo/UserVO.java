package version.mpa.bbs.vo;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 사용자(유저) VO
 */
@Getter
@Setter
public class UserVO {

	/**
	 * PK
	 * auto increment
	 */
	private int id;

	/**
	 * 유저 계정
	 */
	@NonNull
	private String account;

	/**
	 * 유저 비밀번호
	 * 해쉬화
	 */
	@NonNull
	private String password;

	/**
	 * 유저 이름
	 */
	@NonNull
	private String userName;

	/**
	 * 유저 이메일
	 */
	@NonNull
	private String email;

	/**
	 * 계정 생성일
	 */
	@NonNull
	private String created;

	/**
	 * 계정 수정일
	 */
	private String updated;

	/**
	 * 역할코드
	 */
	@NonNull
	private Integer roleCode;

}
