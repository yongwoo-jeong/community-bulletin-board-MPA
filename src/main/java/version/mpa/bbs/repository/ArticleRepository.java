package version.mpa.bbs.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import version.mpa.bbs.mapperInterface.ArticleMapper;
import version.mpa.bbs.util.BatisUtil;
import version.mpa.bbs.vo.ArticleVO;

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
//		try (SqlSession sqlSession = BatisUtil.makeSession()) {
//			ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
//			articleMapper.insertArticle("notice_article",newArticle);
//		}
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
		articleMapper.insertArticle("notice_article",newArticle);
		sqlSession.commit();
		sqlSession.close();

	}

	public List<ArticleVO> selectArticleList(String board, Integer dbLimitOffset)
			throws IOException {
		try (SqlSession sqlSession = BatisUtil.makeSession()) {
			ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
			return articleMapper.selectSearchArticles(board, dbLimitOffset);
		}
	}

}
