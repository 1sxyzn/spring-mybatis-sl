package polymorphism2;

public class TVUser {

	public static void main(String[] args) {
		BeanFactory container = new BeanFactory();
		
		TV tv = (TV) container.getBean(args[0]);
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
