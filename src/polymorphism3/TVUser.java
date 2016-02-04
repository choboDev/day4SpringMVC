package polymorphism3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TVUser {
	public static void main(String[] args) {
		// 1. Spring IoC 컨테이너를 생성(구동)한다.
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring IoC 컨테이너로부터 필요한 객체를 검색(Lookup)한다.
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
