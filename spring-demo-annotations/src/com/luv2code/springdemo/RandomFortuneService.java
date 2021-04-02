package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = {"Suconi e pomponi", "Pomponi e suconi", "Ciuccioni e pompini"};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length); //un numero a cazzo compreso tra 0 e la lunghezza del vettore
		
		return data[index];
	}

}
