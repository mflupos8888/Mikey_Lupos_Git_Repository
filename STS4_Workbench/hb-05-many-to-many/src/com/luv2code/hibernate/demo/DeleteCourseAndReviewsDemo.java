package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;
import com.luv2code.hibernate.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create a Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		// create a Session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();

			// get a course
			int theId = 15;
			Course tempCourse = session.get(Course.class, theId);
			
			// print the retrieved course
			System.out.println("Deleting Course : ");
			System.out.println(tempCourse.toString());
			
			// print the course reviews
			System.out.println(tempCourse.getReviews());
			
			// delete the retrieved course
			session.delete(tempCourse);
			
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