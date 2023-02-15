package version.mpa.bbs.dao;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import version.mpa.bbs.mapperInterface.UserMapper;
import version.mpa.bbs.vo.UserVO;

/**
 * 유저 DAO
 */
public class UserDAO {

	/**
	 * 유저매퍼 로더
	 * TODO SQl세션 try catch문 보완
	 * @return
	 * @throws IOException
	 */
	public UserMapper loadMapper() throws IOException {
		UserMapper mapper;
		String resource = "mybatis-config.xml";
		SqlSessionFactory sqlSessionFactory;
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession(true);
		mapper = session.getMapper(UserMapper.class);
		return mapper;
	}

	/**
	 * 새 유저 DB 삽입
	 * @param newUser 유저 VO
	 * @throws IOException
	 */
	public void insertNewUser(UserVO newUser) throws IOException {
		UserMapper userMapper = loadMapper();
		userMapper.insertUser(newUser);
	}

	/**
	 * select 유저 정보
	 * @param userAccount 유저 계정명
	 * @return 유저 VO
	 * @throws IOException
	 */
	public UserVO selectUser(String userAccount) throws IOException {
		UserMapper userMapper = loadMapper();
		return userMapper.selectUser(userAccount);
	}

}
