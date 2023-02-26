package version.mpa.bbs.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import version.mpa.bbs.mapperInterface.ArticleMapper;
import version.mpa.bbs.vo.ArticleVO;

/**
 * 게시글 레포지토리
 */
public class ArticleRepository {
	/**
	 * ArticleMapper 리턴해주는 메서드
	 * @return
	 * @throws IOException
	 */
	private ArticleMapper loadMapper() throws IOException {
		ArticleMapper articleMapper;
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession(true);
		articleMapper = session.getMapper(ArticleMapper.class);
		return articleMapper;
	}

	/**
	 * 새 게시글 insert
	 * @param newArticle
	 * @throws IOException
	 */
	public void insertArticle(ArticleVO newArticle) throws IOException {
		loadMapper().insertArticle("notice_article",newArticle);
	}

	/**
	 * 게시글 리스트 select
	 * @param board
	 * @param dbLimitOffset
	 * @param searchCriteria
	 * @return
	 * @throws IOException
	 */
	public List<ArticleVO> selectArticleList(String board, Integer dbLimitOffset)
			throws IOException {
		return loadMapper().selectSearchArticles(board, dbLimitOffset);
	}

}
