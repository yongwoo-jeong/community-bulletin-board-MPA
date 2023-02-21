package version.mpa.bbs.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UrlAction {
	CREATE(".new"),
	UPDATE(".update"),
	DELETE(".delete");

	private final String actionUri;
}
