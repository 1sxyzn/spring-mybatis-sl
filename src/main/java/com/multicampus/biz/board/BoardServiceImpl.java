package com.multicampus.biz.board;

import java.util.List;

// 4. Service 구현 클래스 : 비즈니스 로직 처리 담당 (DAO 객체를 사용해서...)
public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
