package com.multicampus.biz;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("business-layer.xml");
		
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setSeq(101);
		vo.setTitle("새글 등록 테스트");
		vo.setWriter("테스터");
		vo.setContent("잘 되어야할텐데...");
		//boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println("[ 게시글 목록 ]");
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		container.close();
	}

}
