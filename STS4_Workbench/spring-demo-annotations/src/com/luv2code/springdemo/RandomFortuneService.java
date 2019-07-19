package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an array of fortune [string]
	private String[] arrayFortune = {
			"win lots of money",
			"win delicious food",
			"win lots of chic clothes",
			"win a new elegent house",
			"win a Mac Pro computer",
			"win lots of love/hearts"
	};
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		// pick a fortune in random from the array [string]
		Random randomNum = new Random();
				
		System.out.println("RandomFortuneService: getFortune()");
		return "RandomFortuneService (getFortune): Today is your lucky day! You will " + arrayFortune[randomNum.nextInt(arrayFortune.length)];
	}

}
