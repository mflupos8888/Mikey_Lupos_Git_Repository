package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	public HappyFortuneService() {
		System.out.println("HappyFortuneService: constructor(default)");
	}
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		System.out.println("HappyFortuneService: (getFortune)");
		return "HappyFortuneService (getFortune): Today is your Happy day!";
	}

}
