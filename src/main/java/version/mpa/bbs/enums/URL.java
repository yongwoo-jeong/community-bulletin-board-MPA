package version.mpa.bbs.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * URL 경로 명세
 */
@Getter
@AllArgsConstructor
public enum URL {
	HOME("/home", "/home.jsp"),
	LOG_IN("/login", "/loginForm.jsp"),
	LOG_OUT("/logout", ""),
	SIGN_UP("/signup", "/signUp.jsp"),
	EDIT_PROFILE("/edit-profile", "/editProfile.jsp"),
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
