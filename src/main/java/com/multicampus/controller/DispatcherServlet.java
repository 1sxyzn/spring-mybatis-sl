package com.multicampus.controller;

import java.io.IOException;
import java.util.List;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardDAOJDBC;
import com.multicampus.biz.board.BoardVO;
import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 브라우저의 요청 path를 추출한다. 
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("추출된 path : " + path);
		
		// 2. 추출한 path에 따라 분기처리한다.
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
			
			// 1. 사용자 입력 정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// 2. DB 연동 처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO dao = new UserDAO();
			UserVO user = dao.getUser(vo);
			
			// 3. 화면 이동
			if(user != null) {
				RequestDispatcher rd = request.getRequestDispatcher("getBoardList.do");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			
		} else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			
			// 1. 로그아웃 요청한 브라우저와 매핑된 세션을 강제 종료한다. 
			HttpSession session = request.getSession();
			session.invalidate();

			// 2. 메인 페이지로 이동
			RequestDispatcher rd = request.getRequestDispatcher("/");
			rd.forward(request, response);
			
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
			
			// 1. 사용자 입력 정보 추출
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO dao = new BoardDAOJDBC();
			dao.insertBoard(vo);
			
			// 3. 화면 이동
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			
			// 1. 사용자 입력 정보 추출
			String title = request.getParameter("title");
			String seq = request.getParameter("seq");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setSeq(Integer.parseInt(seq));
			vo.setContent(content);
			
			BoardDAO dao = new BoardDAOJDBC();
			dao.updateBoard(vo);
			
			// 3. 화면 이동
			RequestDispatcher rd = request.getRequestDispatcher("getBoardList.do");
			rd.forward(request, response);
			
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			
			// 1. 사용자 입력 정보 추출
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO dao = new BoardDAOJDBC();
			dao.deleteBoard(vo);
			
			// 3. 화면 이동
			RequestDispatcher rd = request.getRequestDispatcher("getBoardList.do");
			rd.forward(request, response);
			
		} else if(path.equals("/getBoard.do")) {
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
			
			RequestDispatcher rd = request.getRequestDispatcher("getBoard.jsp");
			rd.forward(request, response);
			
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("글 목록 검색 처리");
			
			// 1. 사용자 입력 정보 추출
			String searchCondition = request.getParameter("searchCondition");
			String searchKeyword = request.getParameter("searchKeyword");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSearchCondition(searchCondition);
			vo.setSearchKeyword(searchKeyword);
			
			BoardDAO dao = new BoardDAOJDBC();
			List<BoardVO> boardList = dao.getBoardList(vo);
			
			// 3. 검색 결과를 세션에 등록하고 목록 화면으로 이동한다. 
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			
			RequestDispatcher rd = request.getRequestDispatcher("getBoardList.jsp");
			rd.forward(request, response);
			
		}
	}

}









