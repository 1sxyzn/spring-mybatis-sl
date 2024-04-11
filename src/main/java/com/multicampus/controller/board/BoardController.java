package com.multicampus.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multicampus.biz.board.BoardDAOJDBC;
import com.multicampus.biz.board.BoardVO;

@Controller
public class BoardController {
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAOJDBC dao) throws Exception {
		dao.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAOJDBC dao) throws Exception {
		dao.updateBoard(vo);
		return "forward:getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAOJDBC dao) throws Exception {
		dao.deleteBoard(vo);
		return "forward:getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAOJDBC dao, ModelAndView mav) throws Exception {
		mav.addObject("board", dao.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
	}
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAOJDBC dao, ModelAndView mav) throws Exception {
		// null check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		mav.addObject("boardList", dao.getBoardList(vo));
		mav.setViewName("getBoardList.jsp");
		return mav;
	}

}





