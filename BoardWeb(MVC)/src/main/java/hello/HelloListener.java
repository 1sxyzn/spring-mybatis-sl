package hello;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class HelloListener implements ServletContextListener {

    public HelloListener() {
        System.out.println("===> HelloListener 생성");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("---> contextInitialized() : 서블릿 컨테이너 생성 직후 호출");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("---> contextDestroyed() : 서블릿 컨테이너 종료 직전 호출");
    }
	
}
