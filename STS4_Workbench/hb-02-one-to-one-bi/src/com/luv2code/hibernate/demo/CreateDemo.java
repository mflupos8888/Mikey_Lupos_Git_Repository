package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create a Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		// create a Session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create a Instructor and Instructor Detail object
			System.out.println("Create new instructor object...");
			Instructor tempInstructor1 = new Instructor("Mikey", "Lupos", "mikeylupos@email.com");
			System.out.println("Instructor created : " + tempInstructor1.toString());

			System.out.println("Create new instructor detail object...");
			InstructorDetail tempInstructorDetail1 = new InstructorDetail("http://www.mikeylupos.com", "Programming");
			System.out.println("InstructorDetail created : " + tempInstructorDetail1.toString());
			
			// associate Instructor with Instructor Detail object
			tempInstructor1.setInstructorDetail(tempInstructorDetail1);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Write the Instructor & Instructor Detail object into MySQL student table...");
			session.save(tempInstructor1);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Update committed...");
			
			// create a Instructor and Instructor Detail object
			System.out.println("Create new instructor object...");
			Instructor tempInstructor2 = new Instructor("Coco", "Lupos", "cocolupos@email.com");
			System.out.println("Instructor created : " + tempInstructor2.toString());

			System.out.println("Create new instructor detail object...");
			InstructorDetail tempInstructorDetail2 = new InstructorDetail("http://www.cocolupos.com", "Watching NDP videos");
			System.out.println("InstructorDetail created : " + tempInstructorDetail2.toString());
			
			// associate Instructor with Instructor Detail object
			tempInstructor2.setInstructorDetail(tempInstructorDetail2);
			
			// create a Session
			session = factory.getCurrentSession();

			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Write the Instructor & Instructor Detail object into MySQL student table...");
			session.save(tempInstructor2);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Update committed...");
			
		}
		finally {
			factory.close();
		}

	}

}
