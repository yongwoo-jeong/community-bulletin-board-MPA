package com.mpa.bbs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
	NOTICE("notice_article","notice_file", "notice_comment", 0),
	/**
	 * 자유게시판
	 */
	GENERAL("general_article", "general_file", "general_comment", 1),
	/**
	 * 자료실
	 */
	LIBRARY("library_article", "library_file", "library_comment", 2),
	/**
	 * 갤러리
	 */
	GALLERY("gallery_article", "gallery_file", "gallery_comment", 3);


	/**
	 * 게시판 테이블명
	 */
	private final String articleTable;

	/**
	 * 파일 테이블명
	 */
	private final String fileTable;

	/**
	 * 댓글 테이블명
	 */
	private final String commentTable;

	/**
	 * 게시판 유형 (board_type 테이블) ID
	 */
	private final Integer boardId;

	public static BoardType getConstantById(Integer boardId) {
		for (BoardType boardType : BoardType.values()) {
			if (Objects.equals(boardType.getBoardId(), boardId)) {
				return boardType;
			}
		}
		return null;
	}

	public static List<Integer> getBoardIdList(){
		List<Integer> boardIdList=  new ArrayList<>();
		for (BoardType boardType : BoardType.values()) {
			boardIdList.add(boardType.getBoardId());
		}
		return boardIdList;
	}


}
