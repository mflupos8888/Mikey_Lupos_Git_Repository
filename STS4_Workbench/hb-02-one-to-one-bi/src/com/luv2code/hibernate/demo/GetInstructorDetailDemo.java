package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class GetInstructorDetailDemo {

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
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int theId = 1;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			// delete the instructor
			if (tempInstructorDetail != null) {

				// display the instructor detail object
				System.out.println("Retrieve Instructor Detail: ");
				System.out.println(tempInstructorDetail);
				
				// display the instructor object
				System.out.println("Retrieve Instructor : ");
				System.out.println(tempInstructorDetail.getInstructor());
				
			}
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Update committed...");
			
		}
		catch (Exception exc ) {
			exc.printStackTrace();
			System.out.println("Exception encountered...");
		}
		finally {
			factory.close();
			System.out.println("Finally...");
		}

	}

}
