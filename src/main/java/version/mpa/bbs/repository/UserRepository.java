package version.mpa.bbs.repository;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import version.mpa.bbs.mapperInterface.UserMapper;
import version.mpa.bbs.vo.UserVO;

/**
 * 유저 레포지토리
 */
public class UserRepository {

	/**
	 * UserMapper 리턴해주는 메서드
	 * @return
	 * @throws IOException
	 */
	private UserMapper loadMapper() throws IOException {
		UserMapper userMapper;
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		try (SqlSession session = sessionFactory.openSession(true)) {
			userMapper = session.getMapper(UserMapper.class);
		}
		return userMapper;
	}

	/**
	 * 로그인 메서드
	 * TODO 유저 로그인 및 필터도 처리
	 * @param userInputAccount 유저 입력 아이디
	 * @return
	 */
	public UserVO selectUser(String userInputAccount) throws IOException {
		return loadMapper().selectUser(userInputAccount);
	}

	/**
	 * 새 사용자 가입 메서드
	 * @param newUser
	 * @throws IOException
	 */
	public void insertUser(UserVO newUser) throws IOException {
		loadMapper().insertUser(newUser);
	}
}
