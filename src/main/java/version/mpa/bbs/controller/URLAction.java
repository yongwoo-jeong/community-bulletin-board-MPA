package version.mpa.bbs.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 게시글, 댓글, 회원 관련 CRUD action url 패턴
 */
@Getter
@AllArgsConstructor
public enum URLAction {
	/**
	 * create
	 */
	NEW(".new"),

	/**
	 * update
	 */
	UPDATE(".update"),

	/**
	 * delete
	 */
	DELETE(".delete");

	/**
	 * URL
	 */
	private final String actionUri;
}
