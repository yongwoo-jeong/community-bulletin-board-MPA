package version.mpa.bbs.mapperInterface;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import version.mpa.bbs.vo.ArticleVO;

/**
 * 게시글 매퍼 인터페이스
 */
@Mapper
public interface ArticleMapper {

	/**
	 * 조건에 맞는 게시글 리턴
	 * @param board 게시판 종류. String substitute(${}) 를 사용하기 때문에 서비스 내에서 정해진 값만 전달
	 * @return 게시글 리스트
	 */
	List<ArticleVO> selectSearchArticles(@Param("board") String board, @Param("dbLimitOffset") Integer dbLimitOffset);
//	, @Param("searchCriteria")
//			SearchCriteriaVO searchCriteria

	void insertArticle(@Param("board") String board, @Param("article") ArticleVO articleVO);


}
