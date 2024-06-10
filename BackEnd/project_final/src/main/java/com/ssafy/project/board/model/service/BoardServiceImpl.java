package com.ssafy.project.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.project.board.model.BoardDto;
import com.ssafy.project.board.model.mapper.BoardMapper;
import com.ssafy.project.board.model.FileInfoDto;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardMapper boardMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper) {
		super();
		this.boardMapper = boardMapper;
	}
	
	@Override
	@Transactional
	public void writeBoard(BoardDto boardDto) throws Exception {
		boardMapper.writeBoard(boardDto);
		String img = boardDto.getImg();
		if (img != null && !img.isEmpty()) {
			boardMapper.registerFile(boardDto);
		}
	}

	@Override
	public List<BoardDto> listBoard() throws Exception {
		return boardMapper.listBoard();
	}

	@Override
	public List<BoardDto> listGroupBoard(int group_id) throws Exception {
		return boardMapper.listGroupBoard(group_id);
	}

	@Override
	public BoardDto getBoard(int id) throws Exception {
		return boardMapper.getBoard(id);
	}

	@Override
	public void updateHit(int id) throws Exception {
		boardMapper.updateHit(id);
	}

	@Override
	public void modifyBoard(BoardDto boardDto) throws Exception {
		boardMapper.modifyBoard(boardDto);
	}

	@Override
	public void deleteBoard(int id) throws Exception {
		boardMapper.deleteBoard(id);
	}

	@Override
	public void good(int id, String user_id) throws Exception {
		boardMapper.good(id, user_id);
	}

	@Override
	public void bad(int id, String user_id) throws Exception {
		boardMapper.bad(id, user_id);
	}

}
