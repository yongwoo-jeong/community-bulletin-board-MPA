package version.mpa.bbs.util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 마이바티스 유틸
 */
public class BatisUtil {
	static SqlSessionFactory sqlSessionFactory;

	/**
	 * 세션팩토리 리턴 메서드
	 * 서블릿 초기화 시 호출
	 * @return
	 * @throws IOException
	 */
	private static SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	public static SqlSession getSqlSession() throws IOException {
		if (sqlSessionFactory==null){
			sqlSessionFactory = getSqlSessionFactory();
		}
		return sqlSessionFactory.openSession(true);
	}
}
