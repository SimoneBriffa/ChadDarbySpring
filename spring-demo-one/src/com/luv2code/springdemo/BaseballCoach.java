package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	// 1 - define a private field for the dependency
	
	// ----------> Una dependency � definibile come un oggetto ausiliario <----------
	
	private FortuneService fortuneService;
	
	// 2 - define a constructor for dependency injection
	
	//3 - configure the dependency injection in Spring config file
	
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		//use my fortuneService to get a fortune
		
		return fortuneService.getFortune();
	}

	
	
}
