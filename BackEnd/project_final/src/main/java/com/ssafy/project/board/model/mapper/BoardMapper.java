package com.ssafy.project.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.project.board.model.BoardDto;
import com.ssafy.project.board.model.FileInfoDto;

@Mapper
public interface BoardMapper {
	void writeBoard(BoardDto boardDto) throws Exception;
//	BoardListDto listArticle(Map<String, String> map) throws Exception;
//	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	List<BoardDto> listBoard() throws Exception;
	List<BoardDto> listGroupBoard(int group_id) throws Exception;
	
	BoardDto getBoard(int id) throws Exception;
	void updateHit(int id) throws Exception;
	
	void modifyBoard(BoardDto boardDto) throws Exception;
	void deleteBoard(int id) throws Exception;
	void good(int id, String user_id) throws Exception;
	void bad(int id, String user_id) throws Exception;
//	List<FileInfoDto> fileInfoList(int articleNo) throws Exception;
	void registerFile(BoardDto boardDto) throws Exception;
	void deleteFile(int id) throws Exception;

}
