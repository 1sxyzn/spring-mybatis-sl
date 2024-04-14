package com.multicampus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	// 로그인 화면으로 이동
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("----> 로그인 화면으로 이동");
		//System.out.println(9/0);
		// Command 객체에 값을 저장하면 JSP에서 사용할 수 있다. 
		vo.setId("guest");
		vo.setPassword("guest123");
		return "login.jsp";
	}
	
	// 로그인 인증 처리
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO dao, HttpSession session) throws Exception {
		System.out.println("----> 로그인 인증 처리");
		UserVO findUser = dao.getUser(vo);
		if(findUser != null) {
			// 로그인 성공 시 회원 정보를 세션에 등록한다.
			session.setAttribute("user", findUser);
			// 뷰이름 앞에 forward:이나 redirect:을 붙이면 ViewResovler는 동작하지 않는다.
			return "forward:getBoardList.do";
		} else {
			return "login.jsp";
		}		
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}
}




