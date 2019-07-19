package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		// retrieve bean
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach betaCoach = context.getBean("tennisCoach", Coach.class);
		
		// check if beans are pointing to the same memory location
		
		boolean result = (alphaCoach == betaCoach);
		
		// perform method
		System.out.println("\n check if same memory location : " + result);
		
		System.out.println("\n memory location of AlphaCoach : " + alphaCoach);
		
		System.out.println("\n memory location of BetaCoach  : " + betaCoach + "\n");
		
		// close
		context.close();
		
	}

}
