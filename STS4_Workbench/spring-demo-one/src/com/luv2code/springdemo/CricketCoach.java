package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	public CricketCoach() {
		System.out.println("Cricket Coach: No args constructor.");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 mins";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("Cricket Coach: FortuneService setter method");
	}
	
}
