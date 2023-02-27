package com.mpa.bbs.service;

import com.mpa.bbs.vo.ArticleVO;
import java.io.IOException;
import com.mpa.bbs.repository.ArticleRepository;

/**
 * 게시글 서비스
 */
public class ArticleService {

	/**
	 * 게시글 검증 후 레포지토리 통해 insert
	 * @param newArticle
	 * @throws IOException
	 */
	public void insert(ArticleVO newArticle) throws IOException {
		// 검증 로직 포함
		new ArticleRepository().insertArticle(newArticle);
	}

}
