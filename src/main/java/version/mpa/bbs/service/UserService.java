package version.mpa.bbs.service;

import java.io.IOException;
import version.mpa.bbs.repository.UserRepository;
import version.mpa.bbs.vo.UserVO;

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
