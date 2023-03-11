package com.mpa.bbs.service;

import com.mpa.bbs.mapper.FileMapper;
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
	 * @param tableName 4 개 파일 테이블 중 삽입
	 * @param newFiles List of file vo
	 * @throws IOException
	 */
	public void insert(String tableName, List<FileVO> newFiles, Integer articleId) throws IOException {
		// TODO 검증 로직
		for (FileVO file:newFiles){
			try (SqlSession sqlSession = BatisUtil.makeSession()) {
				FileMapper fileMapper = sqlSession.getMapper(FileMapper.class);
				fileMapper.insertFile(tableName, file, articleId);
			}
		}
	}

	/**
	 * 파일다운로드를 위한 튜플 반환
	 * @param tableName
	 * @param fileUuid
	 * @return
	 * @throws IOException
	 */
	public FileVO select(String tableName, String fileUuid) throws IOException {
		try (SqlSession sqlSession = BatisUtil.makeSession()) {
			FileMapper fileMapper = sqlSession.getMapper(FileMapper.class);
			return fileMapper.select(tableName, fileUuid);
		}
	}

	/**
	 * 게시글에 따른 파일 반환
	 * @param tableName
	 * @param articleId
	 * @return
	 * @throws IOException
	 */
	public List<FileVO> selectFileList(String tableName, Integer articleId) throws IOException {
		try (SqlSession sqlSession = BatisUtil.makeSession()) {
			FileMapper fileMapper = sqlSession.getMapper(FileMapper.class);
			return fileMapper.selectFileList(tableName, articleId);
		}
	}

	/**
	 * 게시글 리스트 페이지에서 쓰일 파일 첨부 여부
	 * @param fileTable
	 * @param articleTableInteger
	 * @param dbOffsetStart
	 * @param dbOffsetEnd
	 * @return
	 * @throws IOException
	 */
	public List<Integer> selectIsFileAttached(String fileTable, String articleTableInteger, Integer dbOffsetStart, Integer dbOffsetEnd) throws IOException {
		try (SqlSession sqlSession = BatisUtil.makeSession()) {
			FileMapper fileMapper = sqlSession.getMapper(FileMapper.class);
			return fileMapper.selectIsFileAttached(fileTable, articleTableInteger, dbOffsetStart, dbOffsetEnd);
		}
	}
}
