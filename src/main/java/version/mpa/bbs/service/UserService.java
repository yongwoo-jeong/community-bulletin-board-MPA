package version.mpa.bbs.service;

import java.io.IOException;
import version.mpa.bbs.dao.UserDAO;
import version.mpa.bbs.vo.UserVO;

/**
 * 유저 서비스 클래스
 */
public class UserService {
	/**
	 * 로그인 메서드
	 * TODO 유저 로그인 및 필터도 처리
	 * @param userInputAccount 유저 입력 아이디
	 * @return
	 */
	public UserVO selectUser(String userInputAccount) throws IOException {
		return new UserDAO().selectUser(userInputAccount);
	}

	/**
	 * 새 사용자 가입 메서드
	 * @param newUser
	 * @throws IOException
	 */
	public void insertUser(UserVO newUser) throws IOException {
		new UserDAO().insertNewUser(newUser);
	}
}
