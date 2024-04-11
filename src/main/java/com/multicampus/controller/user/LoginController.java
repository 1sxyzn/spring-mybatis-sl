package com.multicampus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO dao, HttpSession session) throws Exception {
		UserVO findUser = dao.getUser(vo);
		if(findUser != null) {
			// 로그인 성공 시 회원 정보를 세션에 등록한다.
			session.setAttribute("user", findUser);
			// 뷰이름 앞에 forward:이나 redirect:을 붙이면 ViewResovler는 동작하지 않는다.
			return "forward:getBoardList.do";
		} else {
			return "forward:login.jsp";
		}		
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}
}




