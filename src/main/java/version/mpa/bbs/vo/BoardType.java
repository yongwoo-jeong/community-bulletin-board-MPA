package version.mpa.bbs.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BoardType {
	NOTICE("notice_article", 0),
	GENERAL("general_article",1),
	LIBRARY("library_article",2),
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
