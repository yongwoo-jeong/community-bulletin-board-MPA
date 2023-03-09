package com.mpa.bbs.mapper;

import com.mpa.bbs.vo.BoardVO;
import java.util.List;

public interface BoardMapper {
	List<BoardVO> selectAllBoard();
}
