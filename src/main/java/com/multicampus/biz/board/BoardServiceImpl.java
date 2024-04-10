package com.multicampus.biz.board;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 4. Service 구현 클래스 : 비즈니스 로직 처리 담당(DAO 객체를 사용해서...)
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAOSPRING boardDAO;

	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo); // 이 줄 수행하고 바로 커밋해버림.
		// boardDAO.insertBoard(vo); // 무결성 위배. 전체가 롤백이 되어야 하는데, 현재 구조 상 롤백 X (위 코드는 이미 커밋되었으므로)
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
