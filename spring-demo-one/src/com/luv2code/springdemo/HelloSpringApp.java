package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// 1 - Load the spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2 - Retrive bean from spring container
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		/*Facciamo riferimento al id (myCoach), e all'interfaccia di riferimento (Coach), in questo
		 * modo Spring effettuerà il cast per noi
		 */
		
		
		
		//3 - Call the methods on the bean
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//4 - close the context
		
		context.close();
		

	}

}
