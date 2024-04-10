package polymorphism2;

public class TVUser {

	public static void main(String[] args) {
		BeanFactory container = new BeanFactory(); // 컨테이너
		
		TV tv = (TV) container.getBean(args[0]); // 내가 new를 하지 않아도 객체 생성
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
