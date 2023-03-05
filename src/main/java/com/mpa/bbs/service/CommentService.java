package com.mpa.bbs.service;

import com.mpa.bbs.mapper.CommentMapper;
import com.mpa.bbs.util.BatisUtil;
import com.mpa.bbs.vo.CommentVO;
import java.io.IOException;
import org.apache.ibatis.session.SqlSession;

/**
 * 댓글 서비스
 */
public class CommentService {

	/**
	 * 댓글 insert
	 * @param tableName 댓글 테이블 이름
	 * @param comment 댓글VO
	 * @throws IOException
	 */
	public void insert(String tableName, CommentVO comment) throws IOException {
		// 검증 로직 포함
		try (SqlSession sqlSession = BatisUtil.makeSession()) {
			CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
			commentMapper.insertComment(tableName, comment);
		}
	}
}
