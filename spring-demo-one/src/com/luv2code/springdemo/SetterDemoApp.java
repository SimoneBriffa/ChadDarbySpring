package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		
		//1 - load the spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2 - retrieve bean from spring container
		
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		/*se la classe terminasse quì, mandando in esecuzione si avrebbe l'output che ci dice
		che siamo dentro al costruttore vuoto e dentro al metodo set, questo per via del file xml */
		
	
		//3 - call methods on the bean
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		//4 - close the context
		
		context.close();
		
	}

}
