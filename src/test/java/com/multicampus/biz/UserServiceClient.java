package com.multicampus.biz;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("business-layer.xml");
		
		UserService userService = (UserService) container.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("admin");
		vo.setPassword("admin123");
		
		UserVO findUser = userService.getUser(vo);
		if(findUser != null) {
			System.out.println(findUser.getName() + "님 로그인 환영^^");
		} else {
			System.out.println("로그인 실패");
		}
		
		container.close();
	}

}
