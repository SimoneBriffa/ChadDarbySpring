package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*oppure @Component("nome_arbitrario")
questo tag collegherà la classe al file xml nel creare i beans. 
Tra parentesi sta l'id nel caso non volessimo adottare quello di defult.
Il id di default corrisponde al nome della classe con la prima lettera minuscola */
@Component
//@Scope("prototype") //crea una nuova istanza ogni volta
public class TennisCoach implements Coach{
	
	/*Autowired è conseguente a Component; cioè Component dice a Java di scannerizzare
	gli elementi presenti nella classe, poi arriva Autowired */
	
	@Autowired //quando c'è più di una classe che implementa Fortune Service bisogna specificare
	@Qualifier("randomFortuneService") //la prima lettera deve essere minuscola
	private FortuneService fortuneService;
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	/*Con il comando Autowired diciamo a spring di cercare un componente che implementi l'interfaccia
	 * FortuneService
	 */
	
	public TennisCoach() {
		System.out.println("Inside default constructor");
	}
	
	//define init method
	
	@PostConstruct
	public void doMyStart() {
		System.out.println("Tenniscoach: inside doMyStart");
	}
	
	@PreDestroy
	public void doMyClean() {
		System.out.println("Tenniscoach: inside doMyClean");
	}
	
	


	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {	
		return fortuneService.getFortune();
	}
	
	/*
	
	@Autowired
	public void suconiepomponi(FortuneService fortuneService) {
		System.out.println("Inside suconiepomponi");
		this.fortuneService = fortuneService;
	} //il metodo per l'injection può avere qualsiasi nome
	
	/*In poche parole, con Autowired possiamo implementare l'interfaccia FortuneService
	evitando di andare a scomodare il file xml ! Si parla appunto di Dependency Injection
	(iniziezione di dipendenza) */
	
}