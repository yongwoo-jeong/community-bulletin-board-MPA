package com.mpa.bbs.controller;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.commands.HomeCommand;
import com.mpa.bbs.commands.article.ArticleDetailCommand;
import com.mpa.bbs.commands.article.ArticleFormCommand;
import com.mpa.bbs.commands.article.ArticleInsertCommand;
import com.mpa.bbs.commands.article.ArticleListCommand;
import com.mpa.bbs.commands.comment.CommentInsertCommand;
import com.mpa.bbs.commands.file.FileDownloadCommand;
import com.mpa.bbs.commands.user.LoginCommand;
import com.mpa.bbs.commands.user.LoginFormCommand;
import com.mpa.bbs.commands.user.LogoutCommand;
import com.mpa.bbs.commands.user.SignupCommand;
import com.mpa.bbs.commands.user.SignupFormCommand;
import java.util.HashMap;
import java.util.Map;

/**
 * URL 주소 - 커맨드 맵
 */
public class CommandMap {

	/**
	 * GET 요청 커맨드 맵
	 */
	private final Map<String, Command> getCommand;
	/**
	 * POST 요청 커맨드 맵
	 */
	private final Map<String, Command> postCommand;

	/**
	 * 디폴트 생성자
	 */
	public CommandMap() {
		// GET 요청 URL, 커맨드
		getCommand = new HashMap<>();
		getCommand.put(URL.HOME.getUrl(), new HomeCommand());
		getCommand.put(URL.SIGNUP.getUrl(), new SignupFormCommand());
		getCommand.put(URL.LOGIN.getUrl(), new LoginFormCommand());
		getCommand.put(URL.LOGOUT.getUrl(), new LogoutCommand());
		getCommand.put(URL.NOTICE.getUrl(), new ArticleListCommand());
		getCommand.put(URL.NEW_NOTICE.getUrl(), new ArticleFormCommand());
		getCommand.put(URL.NOTICE_DETAIL.getUrl(), new ArticleDetailCommand());
		getCommand.put(URL.FILE_DOWNLOAD.getUrl(), new FileDownloadCommand());
		// POST 요청 URL, 커맨드
		postCommand = new HashMap<>();
		postCommand.put(URL.LOGIN.getUrl(), new LoginCommand());
		postCommand.put(URL.SIGNUP.getUrl(), new SignupCommand());
		postCommand.put(URL.NEW_NOTICE.getUrl(), new ArticleInsertCommand());
		postCommand.put(URL.NEW_COMMENT.getUrl(), new CommentInsertCommand());
	}

	/**
	 * GET 요청 커맨드 반환
	 * @param url
	 * @return
	 */
	public Command getCommand(String url) {
		return getCommand.get(url);
	}

	/**
	 * POST 요청 커맨드 반환
	 * @param url
	 * @return
	 */
	public Command postCommand(String url){
		return postCommand.get(url);
	}
}
