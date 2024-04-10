package polymorphism3;

import java.util.Properties;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionUser {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 생성한다. 
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2.  컨테이너로부터 필요한 객체를 검색한다.
		CollectionBean bean = (CollectionBean) container.getBean("collection");
		
		Properties memberList = bean.getAddressList();
		System.out.println("주소 목록");
		for(Object address : memberList.values()) {
			System.out.println("---> " + address.toString());
		}
		
		System.out.println("이름 목록");
		for(Object name : memberList.values()) {
			System.out.println("---> " + name.toString());
		}
		
		// 3. 스프링 컨테이너를 종료한다.
		container.close();
	}

}
