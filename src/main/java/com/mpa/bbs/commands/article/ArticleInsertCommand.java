package com.mpa.bbs.commands.article;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.error.LoginError;
import com.mpa.bbs.service.ArticleService;
import com.mpa.bbs.service.BoardType;
import com.mpa.bbs.service.FileService;
import com.mpa.bbs.util.StringUtil;
import com.mpa.bbs.vo.ArticleVO;
import com.mpa.bbs.vo.FileVO;
import com.mpa.bbs.vo.UserVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * POST 새 게시글 INSERT
 */
public class ArticleInsertCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserVO loginUser = (UserVO) request.getSession().getAttribute("loginUser");
		// 로그인되지 않은 경우 에러페이지
		if (loginUser==null){
			request.setAttribute("errorMessage", LoginError.NOT_LOGIN_USER.getErrorMessage());
			response.sendError(LoginError.NOT_LOGIN_USER.getHttpStatus());
			return;
		}

		// 게시판 유형 URI 를 통해 식별
		String path = request.getRequestURI();
		String boardType = path.substring(path.lastIndexOf('/') + 1, path.lastIndexOf('.')).toUpperCase();
		Integer boardId = BoardType.valueOf(boardType).getBoardId();

		// 멀티파트 파일 저장 경로
		String fileDirectory = new StringUtil().getProperties("multipart.saveDirectory");
		File directoryExists = new File(fileDirectory);
		// 파일 저장 폴더 없을경우 생성
		if (!directoryExists.exists()){
			directoryExists.mkdirs();
		}
		// 파일 설정
		int maxFileSize = 1024 * 1024 * 5;
		FileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy();
		MultipartRequest multipartRequest = new MultipartRequest(request, fileDirectory, maxFileSize, "UTF-8", fileRenamePolicy);

		// 게시글 정보
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		ArticleVO newArticle = ArticleVO.builder().title(title).writer(loginUser.getUserName()).content(content)
				.boardId(boardId).build();

		ArticleService articleService = new ArticleService();
		FileService fileService = new FileService();

		// 전체 파일
		Enumeration files = multipartRequest.getFileNames();
		List<FileVO> validFiles = new ArrayList<>();
		while (files.hasMoreElements()) {
			// TODO 왜 Enumeration<String> 으로 사용하지 않고 굳이 여기서 캐스팅?
			String file = (String) files.nextElement();
			String fileNameOnServer = multipartRequest.getFilesystemName(file);
			String fileNameOriginal = multipartRequest.getOriginalFileName(file);

			// 파일 이름, 사이즈 없을 경우 제외
			if (fileNameOriginal == null)
				continue;
			Integer fileSize = (int) multipartRequest.getFile(file).length();
			String fileExtension = fileNameOriginal.substring(fileNameOriginal.lastIndexOf(".") + 1);
			FileVO newFile = FileVO.builder().nameOnServer(fileNameOnServer).nameOriginal(fileNameOriginal).size(fileSize).path(fileDirectory)
					.extension(fileExtension).build();
			validFiles.add(newFile);
		}

		String articleTable = BoardType.NOTICE.getArticleTable();
		String fileTable = BoardType.NOTICE.getFileTable();
		articleService.insert(articleTable, newArticle);
		Integer newArticleId = newArticle.getId();
		fileService.insert(fileTable, validFiles, newArticleId );

		response.sendRedirect("/noticeDetail?id="+newArticleId);
	}

}
