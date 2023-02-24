package version.mpa.bbs.service;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import version.mpa.bbs.mapperInterface.ArticleMapper;
import version.mpa.bbs.vo.ArticleVO;

public class ArticleService {
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
		try (SqlSession session = sessionFactory.openSession(true)) {
			articleMapper = session.getMapper(ArticleMapper.class);
		}
		return articleMapper;
	}

	public void insertArticle(ArticleVO newArticle) throws IOException {
		loadMapper().insertArticle("notice_article",newArticle);
	}

}
