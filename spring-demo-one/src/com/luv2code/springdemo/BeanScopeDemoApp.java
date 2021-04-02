package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		//1 - load spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//2 - retrieve bean from spring container
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		//check if they are the same
		
		boolean result = theCoach == alphaCoach;
		
		System.out.println("Pointing to the same object? " + result);
		
		System.out.println("Memory location for theCoach: " + theCoach);
		
		System.out.println("Memory location for alphaCoach: " + alphaCoach);
		
		/*finchè lo scope è lasciato in default, sarà in modalità singleton, quindi
		 * sarà istanziato sempre e solo UN solo oggetto. Di conseguenza potremo "creare"
		 * quante versioni vorremo ma informaticamente parlando, sarà sempre la stessa.
		 */
		
		//4 - close
		
		context.close();

	}

}
