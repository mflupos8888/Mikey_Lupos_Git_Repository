package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swimming Coach: Practice breast stroke for 10 lapse";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
