package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class FetchJoinDemo {

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

			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id=:theInstructorId",
					Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get the instructor
			Instructor tempInstructor = query.getSingleResult();

			// show the list of instructor
			System.out.println("luv2code: Instructor : " + tempInstructor);
			
			// retrieve the courses of the instructor
			System.out.println("luv2code: Courses    : " + tempInstructor.getCourses());

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("luv2code: Update committed...");

			// close session
			session.close();
			System.out.println("luv2code: Session Closed!!!");
			
			// retrieve the courses of the instructor
			System.out.println("luv2code: Courses    : " + tempInstructor.getCourses());
			
		}
		finally {
			
			session.close();
			factory.close();
		}

	}

}
