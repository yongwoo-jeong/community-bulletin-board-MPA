package com.mpa.bbs.util;

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
	private static SqlSessionFactory loadSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 세션 팩토리 이용해서 세션 생성 메서드
	 * try with resource 로 사용
	 * @return
	 * @throws IOException
	 */
	public static SqlSession makeSession() throws IOException {
		if (sqlSessionFactory==null){
			sqlSessionFactory = loadSqlSessionFactory();
		}
		return sqlSessionFactory.openSession(true);
	}
}

