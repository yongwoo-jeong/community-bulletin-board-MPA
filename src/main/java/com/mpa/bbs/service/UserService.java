package com.mpa.bbs.service;

import com.mpa.bbs.mapperInterface.UserMapper;
import com.mpa.bbs.util.BatisUtil;
import com.mpa.bbs.vo.UserVO;
import java.io.IOException;
import org.apache.ibatis.session.SqlSession;

/**
 * 유저 서비스
 */
public class UserService {
	/**
	 * 로그인 메서드
	 * TODO 유저 로그인 및 필터도 처리
	 * @param userInputAccount 유저 입력 아이디
	 * @return
	 */
	public UserVO selectUser(String userInputAccount) throws IOException {
		try (SqlSession sqlSession = BatisUtil.makeSession()) {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.selectUser(userInputAccount);
		}
	}

	/**
	 * 새 사용자 가입 메서드
	 * @param newUser
	 * @throws IOException
	 */
	public void insertUser(UserVO newUser) throws IOException {
		try (SqlSession sqlSession = BatisUtil.makeSession()) {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.insertUser(newUser);
		}
	}
}
