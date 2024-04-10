package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.multicampus.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut = "BoardPointcut.getPointcut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		System.out.println("[사후 처리] " + method + "() 메소드 리턴 값 : " + returnObj.toString());
		
		// 비즈니스 메소드가 리턴한 데이터가 UserVO 타입의 객체인지 확인한다. 
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			
			// 리턴된 UserVO 객체의 권한이 Admin인지 확인한다. 
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "님! 관리자 페이지로 이동합니다.");
			}
		}
	}
}
