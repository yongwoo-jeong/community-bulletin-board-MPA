package com.mpa.bbs.repository;

import com.mpa.bbs.repository.mapperInterface.FileMapper;

import com.mpa.bbs.util.BatisUtil;
import com.mpa.bbs.vo.FileVO;
import java.io.IOException;
import org.apache.ibatis.session.SqlSession;

/**
 * 파일 레포지토리
 */
public class FileRepository {

	/**
	 * 새 파일 삽입
	 * @param newFile
	 * @throws IOException
	 */
	public void insert(FileVO newFile) throws IOException {
		try (SqlSession sqlSession = BatisUtil.makeSession()) {
			FileMapper fileMapper = sqlSession.getMapper(FileMapper.class);
		}
	}

}
