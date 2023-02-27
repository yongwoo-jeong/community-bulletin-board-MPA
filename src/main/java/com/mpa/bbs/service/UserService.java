package com.mpa.bbs.service;

import com.mpa.bbs.repository.UserRepository;
import java.io.IOException;
import com.mpa.bbs.vo.UserVO;

/**
 * 유저 서비스
 */
public class UserService {
	public void validate() {
		// validation logic
	}

	public void insert(UserVO newUser) throws IOException {
		new UserRepository().insertUser(newUser);
	}
}
