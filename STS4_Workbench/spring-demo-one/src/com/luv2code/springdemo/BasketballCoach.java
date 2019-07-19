package com.luv2code.springdemo;

public class BasketballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BasketballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice shooting 3s for an hour";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
		
}
