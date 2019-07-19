package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("START SwimJavaConfigDemoApp");
		
		// read configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SwimSportConfig.class);
		System.out.println("context: " + context);
		
		// get the bean
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		System.out.println("SwimJavaConfigDemoApp theCoach: " + theCoach);

		// get work out
		System.out.println("SwimJavaConfigDemoApp: before getDailyWorkout");
		System.out.println(theCoach.getDailyWorkout());
		
		// get fortune
		System.out.println("SwimJavaConfigDemoApp: before getDailyFortune");
		System.out.println(theCoach.getDailyFortune());
		
		// get email
		System.out.println("SwimJavaConfigDemoApp: before getEmail");
		System.out.println(theCoach.getEmail());
		
		// get team
		System.out.println("SwimJavaConfigDemoApp: before getTeam");
		System.out.println(theCoach.getTeam());
		
		// close out
		System.out.println("SwimJavaConfigDemoApp: before closing");
		context.close();
		
		System.out.println("END SwimJavaConfigDemoApp");
	}

}
