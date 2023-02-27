package com.mpa.bbs.util;

import com.mpa.bbs.controller.URL;
import com.mpa.bbs.controller.URLAction;
import java.util.HashMap;
import java.util.Map;

/**
 * JSP 에 쓰일 유틸
 * 값 읽는것만 허용
 */
public class ClientUtil {
	private static final URL[] urlList = URL.values();
	private static final URLAction[] urlAction = URLAction.values();

	public static Map<String, String> getUrls(){
		Map<String, String> urlMap = new HashMap<>();
		for (URL url: urlList) {
			urlMap.put(url.name(),url.getUrlPath());
		}
		return urlMap;
	}

	public static Map<String, String> getActionUri(){
		Map<String, String> urlMap = new HashMap<>();
		for (URLAction action: urlAction) {
			urlMap.put(action.name(), action.getActionUri());
		}
		return urlMap;
	}
}
