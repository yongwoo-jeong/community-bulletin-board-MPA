package version.mpa.bbs.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 게시판 유형
 */
@Getter
@AllArgsConstructor
public enum BoardType {
	/**
	 * 공지사항
	 */
	NOTICE("notice_article", 0),
	/**
	 * 자유게시판
	 */
	GENERAL("general_article",1),
	/**
	 * 자료실
	 */
	LIBRARY("library_article",2),
	/**
	 * 갤러리
	 */
	GALLERY("gallery_article",3);


	/**
	 * 게시판 테이블명
	 */
	private final String tableName;

	/**
	 * 게시판 유형 (board_type 테이블) ID
	 */
	private final Integer boardId;




}
