package com.mpa.bbs.service;

import com.mpa.bbs.error.SignUpError;
import com.mpa.bbs.mapperInterface.UserMapper;
import com.mpa.bbs.util.BatisUtil;
import com.mpa.bbs.util.StringUtil;
import com.mpa.bbs.vo.UserVO;
import java.io.IOException;
import java.util.regex.Pattern;
import org.apache.ibatis.session.SqlSession;

/**
 * 유저 서비스
 */
public class UserService {

	/**
	 * 로그인 메서드
	 * TODO 유저 로그인 및 필터도 처리
	 *
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
	 * 게시글 인풋 필드 검증
	 * @param newUser ArticleVO
	 * @param passwordConfirm String field
	 * @return SignUpError ENUM
	 * @throws IOException
	 */
	public SignUpError validate(UserVO newUser, String passwordConfirm) throws IOException {
		String account = newUser.getAccount();
		if (!Pattern.matches("^[a-z0-9]{5,9}$", account)) {
			return SignUpError.ACCOUNT;
		}
		// 아이디 중복 체크
		if (selectUser(account) != null) {
			return SignUpError.ACCOUNT_EXISTS;
		}
		// 특수문자, 소문자, 숫자 6~ 15자
		String password = newUser.getPassword();
		if (!Pattern.matches("^[a-z0-9`~!@#$%^&*()-_=+]{6,15}$", password)) {
			return SignUpError.PASSWORD;
		}

		if (!Pattern.matches("^[a-z0-9`~!@#$%^&*()-_=+]{6,15}$", passwordConfirm)) {
			return SignUpError.PASSWORD_CONFIRM;
		}
		// 비밀번호, 비밀번호 확인 일치
		if (Boolean.FALSE.equals(StringUtil.isStringMatch(password, passwordConfirm))) {
			return SignUpError.PASSWORD_NOT_MATCH;
		}
		//한글 3,4자
		if (!Pattern.matches("^[ㄱ-ㅎ|가-힣]{3,4}$", newUser.getUserName())) {
			return SignUpError.NAME;
		}
		// 이메일 형식
		if (!Pattern.matches(
				"^[-0-9A-Za-z!#$%&'*+/=?^_`{|}~.]+@[-0-9A-Za-z!#$%&'*+/=?^_`{|}~]+[.][0-9A-Za-z]",
				newUser.getEmail())) {
			return SignUpError.EMAIL;
		}
		return SignUpError.VALID;
	}

	/**
	 * 새 사용자 가입 메서드
	 *
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
