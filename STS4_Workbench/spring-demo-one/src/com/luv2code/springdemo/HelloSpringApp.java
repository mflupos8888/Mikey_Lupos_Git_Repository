package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// load application configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		// retrieve a bean from the configuration file
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// call methods on the coach bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call methods on the fortune bean
		System.out.println(theCoach.getDailyFortune());
		
		// close out
		context.close();
	}

}
