package com.mpa.bbs.commands.file;

import com.mpa.bbs.commands.Command;
import com.mpa.bbs.service.BoardType;
import com.mpa.bbs.service.FileService;
import com.mpa.bbs.vo.FileVO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 파일 다운로드
 * TODO board 타입 쿼리스트링으로 받아 테이블 선택 가능
 */
public class FileDownloadCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileUuid = request.getParameter("uuid");
		String boardType = request.getParameter("board");
		FileVO downloadingFile = new FileService().select(BoardType.NOTICE.getFileTable() ,fileUuid);
		String filePath = downloadingFile.getPath();
		String fileName = downloadingFile.getNameOnServer();
		OutputStream out = response.getOutputStream();
		File file = new File(filePath+fileName);
		String originalName = downloadingFile.getNameOriginal();
		// TODO 파일이 정상적으로 UTF8 인코딩 되었지만 이 과정을 거치지 않으면 파일명이 정상출력 되지 않음.
		String encodedFileName = URLEncoder.encode(originalName, "UTF-8").replace("+", "%20");
		response.setHeader("Cache-Control","no-cache");
		response.addHeader("Content-disposition", "attachment; filename=" +  encodedFileName);

		try (FileInputStream in = new FileInputStream(file)) {
			byte[] buffer = new byte[1024];
			while (true) {
				int count = in.read(buffer);
				if (count == -1) {
					break;
				}
				out.write(buffer, 0, count);
			}
		}
		out.close();
	}
}
