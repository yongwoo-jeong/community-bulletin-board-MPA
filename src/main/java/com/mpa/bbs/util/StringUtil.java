package com.mpa.bbs.util;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * 문자열 유틸리티
 */
public class StringUtil {
	/**
	 * application.property 값 획득
	 * @param propertyKey
	 * @return
	 * @throws IOException
	 */
	public String getProperties(String propertyKey) throws IOException {
		Properties props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
		return props.getProperty(propertyKey);
	}


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
