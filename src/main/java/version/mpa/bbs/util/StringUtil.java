package version.mpa.bbs.util;

import java.util.Objects;

/**
 * 문자열 유틸리티
 */
public class StringUtil {

	/**
	 * 인스턴스 생성 방지
	 */
	private StringUtil(){}

	/**
	 * 두 문자열 일치여부
	 * @param stringOne 비교대상 문자열
	 * @param stringTwo 비교대상 문자열
	 * @return true || false
	 */
	public static Boolean isStringMatch(String stringOne, String stringTwo) {
		return Objects.equals(stringOne, stringTwo);
	}

	/**
	 * 공백문자열 확인
	 * 공백문자열 혹은 null 값이 들어올 경우 True 반환하는 메서드
	 * @param args null 확인 || 공백문자열인지 확인
	 * @return boolean
	 */
	public static boolean isEmpty(Object args){
		return args == null || "".equals(args.toString());
	}

}
