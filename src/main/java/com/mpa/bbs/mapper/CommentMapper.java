package com.mpa.bbs.mapper;

import com.mpa.bbs.vo.CommentVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {

	void insertComment(@Param("commentTable") String commentTable, @Param("comment") CommentVO comment);

	List<CommentVO> selectCommentList(@Param("commentTable") String commentTable, @Param("articleId") Integer articleId);
}
