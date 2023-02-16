package version.mpa.bbs.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * URL 경로 명세
 */
@Getter
@AllArgsConstructor
public enum URL {
	HOME("/home", "/home.jsp"),
	LOGIN("/login", "/loginForm.jsp"),
	SIGNUP("/signup", "/signUp.jsp"),
	ERROR("/error", "/error.jsp");

	private final String urlPath;
	private final String viewPath;

//	public static EnumMap<URLs,String> getUrlMap(){
//		EnumMap<URLs, String> map = new EnumMap<>(URLs.class);
//		for (URLs constant : URLs.values()){
//			map.put(constant, constant.getUrl());
//		}
//		return map;
//	}

}
