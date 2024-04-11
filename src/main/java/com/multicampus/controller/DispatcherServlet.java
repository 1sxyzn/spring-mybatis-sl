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

		} else if(path.equals("/logout.do")) {

		} else if(path.equals("/insertBoard.do")) {

		} else if(path.equals("/updateBoard.do")) {

		} else if(path.equals("/deleteBoard.do")) {
	
		} else if(path.equals("/getBoard.do")) {

		} else if(path.equals("/getBoardList.do")) {
			
		}
	}

}









