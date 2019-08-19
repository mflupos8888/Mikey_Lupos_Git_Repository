package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;
import com.luv2code.hibernate.entity.Review;

public class CreateCourseAndReviewsDemo {

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

			// create a course
			Course tempCourse = new Course("Medicine");
			
			// add some reviews
			tempCourse.addReview(new Review("Excellent"));
			tempCourse.addReview(new Review("Above Average"));
			tempCourse.addReview(new Review("Average"));
			tempCourse.addReview(new Review("Below Average"));
			tempCourse.addReview(new Review("Needs Improvement"));
			
			// save the course ... and leverage cascade all
			session.save(tempCourse);
			System.out.println("Saved Course : " + tempCourse.toString());
			System.out.println(tempCourse.getReviews());
			
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