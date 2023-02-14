package version.mpa.bbs.service;

import lombok.AllArgsConstructor;
import version.mpa.bbs.dao.ArticleDAO;

@AllArgsConstructor
public class LoginService {
	private final ArticleDAO articleDAO;

	/**
	 * 로그인 메서드
	 * TODO 유저 로그인 및 필터도 처리
	 * @param userInputAccount 유저 입력 아이디
	 * @param userInputPassword 유저 입력 비밀번호
	 * @return
	 */
	public Boolean userAuthenticate(String userInputAccount, String userInputPassword){
		return true;
	}

}
