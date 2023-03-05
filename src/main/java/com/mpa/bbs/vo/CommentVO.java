package com.mpa.bbs.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentVO {

	private Integer id;

	@NonNull
	private String writer;

	@NonNull
	private String content;

	private String created;
	private String updated;

	@NonNull
	private Integer articleId;

}
