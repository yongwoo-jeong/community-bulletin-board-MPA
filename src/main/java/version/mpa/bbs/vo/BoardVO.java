package version.mpa.bbs.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 게시판 VO
 */
@Getter
@Setter
public class BoardVO {

	/**
	 * PK
	 * auto increment
	 */
	private int id;

	/**
	 * 게시판명
	 */
	private String name;

	/**
	 * 댓글 기능 여부
	 */
	private int isCommentAttached;

	/**
	 * 파일 첨부 기능 여부
	 */
	private int isFileAttached;

	/**
	 * 읽기 권한 범위
	 */
	private String readAllow;

	/**
	 * 글쓰기 권한 범위
	 */
	private String writeAllow;

	/**
	 * 댓글 권한 범위
	 */
	private String replyAllow;

}
