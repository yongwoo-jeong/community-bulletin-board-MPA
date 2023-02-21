package version.mpa.bbs.util;

import java.util.HashMap;
import java.util.Map;
import version.mpa.bbs.controller.URL;

/**
 * JSP 에 쓰일 유틸
 */
public class ViewUtil {
	static URL[] urlList = URL.values();

	public static Map<String, String> getUrls(){
		Map<String, String> urlMap = new HashMap<>();
		for (URL url: urlList) {
			urlMap.put(url.name(),url.getUrlPath());
		}
		return urlMap;
	}
}
