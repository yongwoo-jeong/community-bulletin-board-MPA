package com.mpa.bbs.repository;

import com.mpa.bbs.repository.mapperInterface.ArticleMapper;
import com.mpa.bbs.util.BatisUtil;
import com.mpa.bbs.vo.ArticleVO;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 * 게시글 레포지토리
 */
public class ArticleRepository {

	/**
	 * 새 게시글 insert
	 * @param newArticle
	 * @throws IOException
	 */
	public void insertArticle(ArticleVO newArticle) throws IOException {
		try (SqlSession sqlSession = BatisUtil.makeSession()) {
			ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
			articleMapper.insertArticle("notice_article",newArticle);
		}
	}

	public List<ArticleVO> selectArticleList(String board, Integer dbLimitOffset) throws IOException {
		try (SqlSession sqlSession = BatisUtil.makeSession()) {
			ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
			return articleMapper.selectSearchArticles(board, dbLimitOffset);
		}
	}

}
