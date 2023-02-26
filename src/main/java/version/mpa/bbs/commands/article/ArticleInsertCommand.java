package version.mpa.bbs.commands.article;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import version.mpa.bbs.commands.Command;
import version.mpa.bbs.service.ArticleService;
import version.mpa.bbs.service.FileService;
import version.mpa.bbs.util.StringUtil;
import version.mpa.bbs.vo.ArticleVO;
import version.mpa.bbs.vo.FileVO;

/**
 * POST 새 게시글 INSERT
 */
public class ArticleInsertCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 멀티파트 파라미터
		String fileDirectory = new StringUtil().getProperties("multipart.saveDirectory");
		File directoryExists = new File(fileDirectory);
		// 파일 저장 폴더 없을경우 생성
		if (!directoryExists.exists()){
			directoryExists.mkdirs();
		}
		int maxFileSize = 1024 * 1024 * 5;
		FileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy();
		MultipartRequest multipartRequest = new MultipartRequest(request, fileDirectory, maxFileSize, "UTF-8", fileRenamePolicy);

		String writer = multipartRequest.getParameter("writer");
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		ArticleVO newArticle = ArticleVO.builder().title(title).writer(writer).content(content).build();

		ArticleService articleService = new ArticleService();
		FileService fileService = new FileService();
		articleService.insert(newArticle);

		// 전체 파일
		Enumeration files = multipartRequest.getFileNames();
		while (files.hasMoreElements()) {
			String file = (String) files.nextElement();
			String fileNameOnServer = multipartRequest.getFilesystemName(file);
			String fileNameOriginal = multipartRequest.getOriginalFileName(file);
			int fileSize = (int) multipartRequest.getFile(file).length();
			// 파일 이름, 사이즈 없을 경우 제외
			if (fileNameOriginal == null || fileSize == 0)
				continue;
			String fileExtension = fileNameOriginal.substring(fileNameOriginal.lastIndexOf(".") + 1);
			FileVO newFile = FileVO.builder().nameOnServer(fileNameOnServer).nameOriginal(fileNameOriginal).size(fileSize).path(fileDirectory)
					.extension(fileExtension).build();
		fileService.insert(newFile);
		}
	}

}
