package com.multicampus.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
                    
@Service
@Aspect
public class AroundAdvice {
	
	@Around("BoardPointcut.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		// 클라이언트가 호출한 메소드 이름을 추출한다. 
		String method = jp.getSignature().getName();
		
		Object obj = null;
		StopWatch watch = new StopWatch();
		
		watch.start();
		obj = jp.proceed(); // 클라이언트가 호출한 Biz 메소드가 실행되는 시점
		watch.stop();
		
		System.out.println(method + "() 메소드 수행에 소요된 시간 : " + watch.getTotalTimeSeconds());
		return obj;
	}
}
