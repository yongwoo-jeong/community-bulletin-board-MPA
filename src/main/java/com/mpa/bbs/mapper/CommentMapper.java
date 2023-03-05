package com.mpa.bbs.mapper;

import com.mpa.bbs.vo.CommentVO;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {

	void insertComment(@Param("commentTable") String commentTable, @Param("comment") CommentVO comment);
}
