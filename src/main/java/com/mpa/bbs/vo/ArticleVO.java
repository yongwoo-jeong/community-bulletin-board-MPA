package com.mpa.bbs.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 게시글 VO
 */
@Getter
@Setter
@Builder
public class ArticleVO {

	/**
	 * 게시글 ID (PK)
	 * auto increment
	 */
	private Integer id;

	/**
	 * 게시글 제목
	 */
	@NonNull
	private String title;

	/**
	 * 게시글 작성자
	 */
	@NonNull
	private String writer;

	/**
	 * 게시글 조회수
	 */
	private Integer view;

	/**
	 * 게시글 내용
	 */
	@NonNull
	private String content;

	/**
	 * 게시글 생성일
	 * NOW()
	 */
	private String created;

	/**
	 * 게시글 수정일
	 * NOW()
	 */
	private String updated;

	/**
	 * 게시판 ID
	 */
	private Integer boardId;
}
