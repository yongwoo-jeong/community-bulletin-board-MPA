package version.mpa.bbs.service;

import java.io.IOException;
import lombok.AllArgsConstructor;
import version.mpa.bbs.dao.ArticleDAO;
import version.mpa.bbs.dao.UserDAO;
import version.mpa.bbs.vo.UserVO;

@AllArgsConstructor
public class UserService {
	private final UserDAO userDAO;

	/**
	 * 로그인 메서드
	 * TODO 유저 로그인 및 필터도 처리
	 * @param userInputAccount 유저 입력 아이디
	 * @param userInputPassword 유저 입력 비밀번호
	 * @return
	 */
	public Boolean userLogin(String userInputAccount, String userInputPassword){
		return true;
	}

	public void userSignUp(UserVO newUser) throws IOException {
		userDAO.insertNewUser(newUser);
	}

}
