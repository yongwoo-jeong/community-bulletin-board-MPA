package version.mpa.bbs.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 유저 역할(권한명) VO
 */
@Getter
@Setter
public class RoleVO {

	/**
	 * 역할코드 (PK)
	 */
	private int id;

	/**
	 * 역할명
	 */
	private String name;
}
