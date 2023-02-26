package version.mpa.bbs.service;

import java.io.IOException;
import version.mpa.bbs.repository.ArticleRepository;
import version.mpa.bbs.vo.ArticleVO;

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
