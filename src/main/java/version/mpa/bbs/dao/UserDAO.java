package version.mpa.bbs.dao;

import java.io.IOException;
import java.io.InputStream;
import lombok.AllArgsConstructor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import version.mpa.bbs.mapperInterface.UserMapper;
import version.mpa.bbs.vo.UserVO;

public class UserDAO {
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

	public void insertNewUser(UserVO newUser) throws IOException {
		UserMapper userMapper = loadMapper();
		userMapper.insertUser(newUser);
	}
}
