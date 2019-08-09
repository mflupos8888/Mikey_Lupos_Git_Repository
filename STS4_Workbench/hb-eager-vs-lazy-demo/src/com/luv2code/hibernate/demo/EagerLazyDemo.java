package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create a Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		// create a Session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();

			// get an instructor
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("Instructor : " + tempInstructor);
			
			// retrieve the courses of the instructor
			System.out.println("Courses    : " + tempInstructor.getCourses());
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Update committed...");

		}
		finally {
			
			session.close();
			factory.close();
		}

	}

}
