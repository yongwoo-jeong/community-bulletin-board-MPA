package com.mpa.bbs.mapperInterface;

import com.mpa.bbs.vo.FileVO;
import org.apache.ibatis.annotations.Param;

/**
 * 파일 매퍼 인터페이스
 */
public interface FileMapper {

	/**
	 * 새 파일 삽입
	 */
	void insertFile(@Param("tableName") String tableName ,@Param("newFile") FileVO newFile, @Param("articleId") Integer articleId);
}
