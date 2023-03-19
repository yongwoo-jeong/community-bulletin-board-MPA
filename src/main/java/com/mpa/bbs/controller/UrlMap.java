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
public class UrlMap {

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
	public UrlMap() {
		// GET 요청 URL, 커맨드
		getCommand = new HashMap<>();
		getCommand.put("/home", new HomeCommand());
		getCommand.put("/signup", new SignupFormCommand());
		getCommand.put("/login", new LoginFormCommand());
		getCommand.put("/logout", new LogoutCommand());
		getCommand.put("/notice", new ArticleListCommand());
		getCommand.put("/notice.new", new ArticleFormCommand());
		getCommand.put("/noticeDetail", new ArticleDetailCommand());
		getCommand.put("/download", new FileDownloadCommand());
		// POST 요청 URL, 커맨드
		postCommand = new HashMap<>();
		postCommand.put("/login", new LoginCommand());
		postCommand.put("/signup", new SignupCommand());
		postCommand.put("/notice.new", new ArticleInsertCommand());
		postCommand.put("/comment.new", new CommentInsertCommand());
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
