package com.multicampus.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	@Pointcut("execution(* com.multicampus.biz..*Impl.*(..))")
	public void allPointcut() {}

	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		// 클라이언트가 호출한 메소드 이름 추출
		String method = jp.getSignature().getName();
		
		Object obj = null;
		StopWatch watch = new StopWatch();
		
		watch.start();
		System.out.println("---[ Before Logic ]---");
		watch.stop();
		
		obj = jp.proceed(); // 클라이언트가 호출한 biz 메소드가 실행되는 시점
		
		System.out.println(method + " 비즈니스 메소드 수행에 걸린 시간 : "+ watch.getTotalTimeSeconds());
		return obj;
	}
}

