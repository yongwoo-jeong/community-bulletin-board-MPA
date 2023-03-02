package com.mpa.bbs.util;

import com.mpa.bbs.controller.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * JSP 에 쓰일 유틸
 * 값 읽는것만 허용
 */
public class ClientUtil {
	private static final URL[] urlList = URL.values();

	public static Map<String, String> getUrls(){
		Map<String, String> urlMap = new HashMap<>();
		for (URL url: urlList) {
			urlMap.put(url.name(),url.getUrlPath());
		}
		return urlMap;
	}

}
