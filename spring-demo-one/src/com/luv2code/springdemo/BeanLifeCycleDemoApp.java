package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		//1 - load spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		//2 - retrieve bean from spring container
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		
		//check if they are the same
		
		System.out.println(theCoach.getDailyWorkout());
		
		/*finch� lo scope � lasciato in default, sar� in modalit� singleton, quindi
		 * sar� istanziato sempre e solo UN solo oggetto. Di conseguenza potremo "creare"
		 * quante versioni vorremo ma informaticamente parlando, sar� sempre la stessa.
		 */
		
		//4 - close
		
		context.close();

	}

}
