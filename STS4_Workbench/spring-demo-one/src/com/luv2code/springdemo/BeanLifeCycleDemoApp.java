package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Load Configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-ApplicationContext.xml");
				
		//Retrieve Bean
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("theCoach is same as alphaCoach : " + result);
		
		System.out.println("the memory location of theCoach is   : " + theCoach);
		System.out.println("the memory location of alphaCoach is : " + alphaCoach);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(alphaCoach.getDailyWorkout());
		
		//Close files
		context.close();
	}

}
