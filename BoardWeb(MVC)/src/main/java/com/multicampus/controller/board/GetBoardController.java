package com.multicampus.controller.board;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardDAOJDBC;
import com.multicampus.biz.board.BoardVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GetBoardController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 상세 조회 처리");
		
		// 1. 사용자 입력 정보 추출
		String seq = request.getParameter("seq");

		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO dao = new BoardDAOJDBC();
		BoardVO board = dao.getBoard(vo);
		
		// 3. 검색 결과를 세션에 등록하고 상세 화면으로 이동한다. 
		HttpSession session = request.getSession();
		session.setAttribute("board", board);

		// 4. 화면 이동
		// ModelAndView 객체에 이동할 화면 이름을 설정하여 리턴하면 자동으로 forward 된다.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoard.jsp");
		return mav;
	}

}
