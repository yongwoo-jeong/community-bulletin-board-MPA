package com.mpa.bbs.service;

import com.mpa.bbs.mapperInterface.ArticleMapper;
import com.mpa.bbs.util.BatisUtil;
import com.mpa.bbs.vo.ArticleVO;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 * 게시글 서비스
 */
public class ArticleService {

	/**
	 * 게시글 검증 후 레포지토리 통해 insert
	 * @param newArticle
	 * @throws IOException
	 */
	public void insert(ArticleVO newArticle) throws IOException {
		// 검증 로직 포함
		try (SqlSession sqlSession = BatisUtil.makeSession()) {
			ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
			articleMapper.insertArticle("notice_article", newArticle);
		}
	}

	public List<ArticleVO> selectArticleList(String boardType, Integer dbLimitOffset) throws IOException {
		try (SqlSession sqlSession = BatisUtil.makeSession()) {
			ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
			return articleMapper.selectSearchedArticles(dbLimitOffset);
		}
	}

}
