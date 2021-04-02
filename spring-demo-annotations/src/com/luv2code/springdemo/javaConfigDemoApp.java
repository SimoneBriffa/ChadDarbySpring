package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class javaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config file
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		//come parametro non più un file xml ma una classe
		
		
		//get the bean from spring container
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//call a method on the bean
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//close the context

		context.close();
	}

}
