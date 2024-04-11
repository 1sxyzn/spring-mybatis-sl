package com.multicampus.controller.user;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그아웃 처리");
		
		// 1. 로그아웃 요청한 브라우저와 매핑된 세션을 강제 종료한다. 
		HttpSession session = request.getSession();
		session.invalidate();

		// 2. 화면 이동
		// ModelAndView 객체에 이동할 화면 이름을 설정하여 리턴하면 자동으로 forward 된다.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/");
		return mav;
	}

}
