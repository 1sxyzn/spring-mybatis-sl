<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. Forward 방식
	//RequestDispatcher rd = request.getRequestDispatcher("b.jsp");
	//rd.forward(request, response);
	
	// 2. Redirect 방식
	response.sendRedirect("b.jsp");
%>