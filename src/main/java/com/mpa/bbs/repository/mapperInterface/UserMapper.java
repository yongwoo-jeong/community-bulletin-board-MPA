package com.mpa.bbs.repository.mapperInterface;

import org.apache.ibatis.annotations.Param;
import com.mpa.bbs.vo.UserVO;

/**
 * 유저 매퍼
 */
public interface UserMapper {

	/**
	 * select 유저 인포메이션
 	 * @param account 유저 계정명
	 * @return UserVO
	 */
	UserVO selectUser(@Param("account") String account);

	/**
	 * 새 유저 insert
	 * @param newUser userVO
	 */
	void insertUser(@Param("newUser") UserVO newUser);
}
