package com.mpa.bbs.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentVO {

	private Integer id;
	private String writer;
	private String content;
	private String created;
	private String updated;
	private Integer articleId;

}
