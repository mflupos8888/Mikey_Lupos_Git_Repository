package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("START JavaConfigDemoApp");
		
		// read configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		System.out.println("context: " + context);
		
		// get the bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		System.out.println("theCoach: " + theCoach);

		// get work-out
		System.out.println("JavaConfigDemoApp: before getDailyWorkout");
		System.out.println(theCoach.getDailyWorkout());
		
		// get fortune
		System.out.println("JavaConfigDemoApp: before getDailyFortune");
		System.out.println(theCoach.getDailyFortune());
		
		// close out
		System.out.println("JavaConfigDemoApp: before closing");
		context.close();
		
		System.out.println("END JavaConfigDemoApp");
	}

}
