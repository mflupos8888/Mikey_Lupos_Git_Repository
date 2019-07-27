package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;
import com.luv2code.hibernate.entity.Student;

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
			/*
			// create a Instructor and Instructor Detail object
			System.out.println("Create new instructor object...");
			Instructor tempInstructor = new Instructor("Mikey", "Lupos", "mikeylupos@email.com");
			System.out.println("Instructor created : " + tempInstructor.toString());

			System.out.println("Create new instructor detail object...");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.mikeylupos.com", "Programming");
			System.out.println("InstructorDetail created : " + tempInstructorDetail.toString());
			
			// associate Instructor with Instructor Detail object
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			*/
			
			// create a Instructor and Instructor Detail object
			System.out.println("Create new instructor object...");
			Instructor tempInstructor = new Instructor("Coco", "Lupos", "cocolupos@email.com");
			System.out.println("Instructor created : " + tempInstructor.toString());

			System.out.println("Create new instructor detail object...");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.cocolupos.com", "Watching NDP videos");
			System.out.println("InstructorDetail created : " + tempInstructorDetail.toString());
			
			// associate Instructor with Instructor Detail object
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Write the Instructor & Instructor Detail object into MySQL student table...");
			session.save(tempInstructor);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Update committed...");
			
		}
		finally {
			factory.close();
		}

	}

}
