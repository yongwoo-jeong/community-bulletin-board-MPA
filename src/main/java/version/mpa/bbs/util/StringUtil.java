package version.mpa.bbs.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;

/**
 * 문자열 유틸리티
 */
public class StringUtil {
	/**
	 * 인스턴스 생성 방지
	 */
	public StringUtil(){}

	/**
	 * application.property 값 획득
	 * @param propertyKey
	 * @return
	 * @throws IOException
	 */
	public String getProperties(HttpServletRequest request, String propertyKey) throws IOException {
		String configFilePath = request.getServletContext().getRealPath("/WEB-INF/application.properties");
		Properties prop;
		try (FileReader fileReader = new FileReader(configFilePath)) {
			prop = new Properties();
			prop.load(fileReader);
			return prop.getProperty(propertyKey);
		}
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
