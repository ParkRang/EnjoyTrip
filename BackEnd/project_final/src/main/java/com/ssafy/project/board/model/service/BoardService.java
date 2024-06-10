package com.ssafy.project.board.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.project.board.model.BoardDto;
import com.ssafy.project.board.model.BoardListDto;

public interface BoardService {
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
	
}
