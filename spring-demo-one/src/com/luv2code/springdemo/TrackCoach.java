package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It: " + fortuneService.getFortune();
	}
	
	
	/*Creiamo dei metodi di init e di destroy connesso al lifecycle di un bean;
	 * -questi metodi possono avere qualsiasi modificatore di accesso;
	 * -NON possono avere parametri;
	 * -possono ritornare qualsiasi tipo ma di fatto non ha senso mettere qualcosa di diverso
	 * dal void perchè non è impossibile usufruire del return;
	 * -possono avere un nome arbitrario
	 */
	
	
	//add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	//add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: inside method doMyCleanupStuff");
	}
	
	//N.B. per un bean dichiarato prototype non possibile applicare il metodo di destroy

}
