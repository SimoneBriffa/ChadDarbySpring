package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	//1 - retrieve bean from spring container
	
	Coach theCoach = context.getBean("tennisCoach", Coach.class);
	
	Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
	
	//2 - check if they are the same
	
	boolean result = (theCoach == alphaCoach);
	
	
    
	
	
}
