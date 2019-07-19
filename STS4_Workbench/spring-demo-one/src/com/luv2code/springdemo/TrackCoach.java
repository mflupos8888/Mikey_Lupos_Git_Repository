package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {

	}
	
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5K";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	// add an init-method
	
	public void performInitMethod() {
		System.out.println("Track Coach: Initializing...");
	}
	
	// add a destroy-method
	
	public void performDestroyMethod() {
		System.out.println("Track Coach: Destroying...");
	}

}
