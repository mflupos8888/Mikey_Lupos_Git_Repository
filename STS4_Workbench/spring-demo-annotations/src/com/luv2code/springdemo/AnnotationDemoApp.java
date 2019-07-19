package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("START AnnotationDemoApp");
		
		// read configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		System.out.println("context: " + context);
		
		// get the bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		System.out.println("theCoach: " + theCoach);

		// get work-out
		System.out.println("AnnotationDemoApp: before getDailyWorkout");
		System.out.println(theCoach.getDailyWorkout());
		
		// get fortune
		System.out.println("AnnotationDemoApp: before getDailyFortune");
		System.out.println(theCoach.getDailyFortune());
		
		// close out
		System.out.println("AnnotationDemoApp: before closing");
		context.close();
		
		System.out.println("END AnnotationDemoApp");
	}

}
