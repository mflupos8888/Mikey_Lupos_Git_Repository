package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
//   default constructor
	public TennisCoach() {
		System.out.println("TennisCoach: constructor(default)");
	}
	
	@PostConstruct
	public void DoMyStartupStuff() {
		System.out.println("TennisCoach : DoMyStartupStuff.");
	}
	
	@PreDestroy
	public void DoMyDestroyStuff() {
		System.out.println("TennisCoach : DoMyDestroyStuff.");
	}

//	auto wired setter method
//	@Autowired
//	public void doSomeCrazyStuff (FortuneService fortuneService) {
//		System.out.println("TennisCoach setter(doSomeCrazyStuff): " + fortuneService);
//		this.fortuneService = fortuneService; 
//	}
	
//	auto wired constructor method	
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		System.out.println("TennisCoach constructor(fortuneService): " + fortuneService);
//		this.fortuneService = fortuneService;
//	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Tennis Coach: Practice your forehand and backhand swing!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
