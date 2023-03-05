package com.mpa.bbs.mapper;

import com.mpa.bbs.vo.ArticleVO;
import com.mpa.bbs.vo.SearchVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 게시글 매퍼 인터페이스
 */
@Mapper
public interface ArticleMapper {

	/**
	 * 총 게시글 수
	 * @param board
	 * @return
	 */
	Integer selectArticleCount(@Param("tableName") String tableName, @Param("searchCriteria") SearchVO searchCriteria);

	/**
	 * 조건에 맞는 게시글 리턴
	 * @param tableName 게시판 종류. String substitute(${}) 를 사용하기 때문에 서비스 내에서 정해진 값만 전달
	 * @return 게시글 리스트
	 */
	List<ArticleVO> selectSearchedArticles(@Param("tableName") String tableName , @Param("searchCriteria") SearchVO searchCriteria);
//	, @Param("searchCriteria")
//			SearchCriteriaVO searchCriteria

	void insertArticle(@Param("tableName") String tableName, @Param("article") ArticleVO article);

	ArticleVO select(@Param("tableName") String tableName, @Param("articleId") Integer articleId);
}
