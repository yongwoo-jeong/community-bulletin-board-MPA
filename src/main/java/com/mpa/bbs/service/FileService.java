package com.mpa.bbs.service;

import com.mpa.bbs.mapperInterface.FileMapper;
import com.mpa.bbs.util.BatisUtil;
import com.mpa.bbs.vo.FileVO;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

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
			try (SqlSession sqlSession = BatisUtil.makeSession()) {
				FileMapper fileMapper = sqlSession.getMapper(FileMapper.class);
			}
		}
	}
}
