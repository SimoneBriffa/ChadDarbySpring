package com.timbuchalka.springdemo;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCApp2 {

	public static void main(String[] args) {
		// create application context (container)
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		/*La differenza tra questa classe ClassPath e la classe FileSystem è che
		 * il file xml deve trovarsi in una cartella appropriata
		 */
		
		Organization org = (Organization) ctx.getBean("myorg");
		
		org.corporateSlogan();
		
		((ClassPathXmlApplicationContext) ctx).close();
		
	}

}
