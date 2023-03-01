package com.mpa.bbs.service;

import com.mpa.bbs.mapperInterface.ArticleMapper;
import com.mpa.bbs.util.BatisUtil;
import com.mpa.bbs.vo.ArticleVO;
import com.mpa.bbs.vo.SearchVO;
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

	/**
	 * TODO Set SearchCondition
	 * @param boardType
	 * @return
	 */
	public Integer selectArticleCount(String boardType, SearchVO searchCriteria) throws IOException {
		try (SqlSession sqlSession = BatisUtil.makeSession()) {
			ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
			return articleMapper.selectArticleCount(boardType, searchCriteria);
		}
	}

	/**
	 * TODO Set SearchCondition
	 *
	 * @param boardType
	 * @return
	 * @throws IOException
	 */
	public List<ArticleVO> selectArticleList(String boardType, SearchVO searchCriteria) throws IOException {
		try (SqlSession sqlSession = BatisUtil.makeSession()) {
			ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
			return articleMapper.selectSearchedArticles(boardType, searchCriteria);
		}
	}

}
