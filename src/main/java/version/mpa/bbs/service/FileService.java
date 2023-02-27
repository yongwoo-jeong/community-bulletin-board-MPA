package version.mpa.bbs.service;

import java.util.ArrayList;
import java.util.List;
import version.mpa.bbs.repository.FileRepository;
import version.mpa.bbs.vo.FileVO;

/**
 * 파일 관련 서비스
 */
public class FileService {

	/**
	 * 파일 검증 이후 insert
	 * @param file
	 */
	public void insert(List<FileVO> newFiles){
		// 검증 로직
		for (FileVO file:newFiles){
			new FileRepository().insert(file);
		}
	}
}
