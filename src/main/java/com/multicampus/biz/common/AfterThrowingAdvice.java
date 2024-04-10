package com.multicampus.biz.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	
	@Pointcut("execution(* com.multicampus.biz..*Impl.*(..))")
	public void allPointcut() {}

	@AfterThrowing(pointcut="allPointcut()", throwing="exceptionObj")
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		String method = jp.getSignature().getName();
		System.out.println("[예외 처리] " + method + "()메소드 수행 중 예외 발생");
		// 발생된 예외에 따른 분기 처리
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("0번 글을 등록할 수 없습니다.");
		}
		else if(exceptionObj instanceof ArithmeticException) {
			System.out.println("0으로 숫자를 나눌 수 없습니다.");
		}
		else if(exceptionObj instanceof SQLException) {
			System.out.println("SQL 구문에 문법 오류가 있습니다.");
		}
		else {
			System.out.println("문제 발생!");
		}
	}
}
