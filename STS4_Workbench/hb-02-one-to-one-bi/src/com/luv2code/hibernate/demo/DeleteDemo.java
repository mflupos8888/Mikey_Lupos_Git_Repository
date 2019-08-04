package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class DeleteDemo {

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
			
			int theId = 7;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Delete Instructor : ");
			System.out.println(tempInstructor);
			
			// delete the instructor
			if (tempInstructor != null) {
				session.delete(tempInstructor);
				System.out.println("Delete action completed!");
			}
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Update committed...");
			
		}
		finally {
			factory.close();
		}

	}

}
