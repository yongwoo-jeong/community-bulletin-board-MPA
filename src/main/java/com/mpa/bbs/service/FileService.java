package com.mpa.bbs.service;

import com.mpa.bbs.repository.FileRepository;
import com.mpa.bbs.vo.FileVO;
import java.io.IOException;
import java.util.List;

/**
 * 파일 관련 서비스
 */
public class FileService {

	/**
	 * 파일 검증 이후 insert
	 * @param newFiles
	 * @throws IOException
	 */
	public void insert(List<FileVO> newFiles) throws IOException {
		// 검증 로직
		for (FileVO file:newFiles){
			new FileRepository().insert(file);
		}
	}
}
