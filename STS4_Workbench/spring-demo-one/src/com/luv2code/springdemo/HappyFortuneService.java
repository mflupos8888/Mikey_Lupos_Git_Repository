package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	private String[] arrayOfFortunes;
	private int      maxArrayElements;

	public HappyFortuneService() {
		System.out.println("HappyFortuneService: No args");
	}

	public void setArrayOfFortunes(String[] arrayOfFortunes) {
		this.arrayOfFortunes = arrayOfFortunes;
	}
	
	public void setMaxArrayElements(int maxArrayElements) {
		this.maxArrayElements = maxArrayElements;
	}
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		Random randomNum = new Random();
		
		return "Today you will win " + arrayOfFortunes[randomNum.nextInt(maxArrayElements)];
	}
	
}
