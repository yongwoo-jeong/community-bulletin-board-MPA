package version.mpa.bbs.util;

import java.util.HashMap;
import java.util.Map;
import version.mpa.bbs.controller.URLAction;
import version.mpa.bbs.controller.URL;

/**
 * JSP 에 쓰일 유틸
 */
public class ViewUtil {
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
