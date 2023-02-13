package version.mpa.bbs.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * URL 경로 명세
 */
@Getter
@AllArgsConstructor
public enum URLs {
	HOME("/"),
	LOGIN("/login"),
	SIGN_UP("/signup");

	private final String url;

//	public static EnumMap<URLs,String> getUrlMap(){
//		EnumMap<URLs, String> map = new EnumMap<>(URLs.class);
//		for (URLs constant : URLs.values()){
//			map.put(constant, constant.getUrl());
//		}
//		return map;
//	}

}
