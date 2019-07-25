package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create a Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create a Session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Create new student object...");
			Student tempStudent1 = new Student("Carla", "Lupos", "carlalupos@email.com");
			Student tempStudent2 = new Student("Coco", "Lupos", "cocolupos@email.com");
			Student tempStudent3 = new Student("Michael William", "Lupos", "michaewilliamlupos@email.com");
			Student tempStudent4 = new Student("Mikey", "Lupos", "mikeylupos@email.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student object into MySQL student table...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.save(tempStudent4);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Update committed...");
			
		}
		finally {
			factory.close();
		}

	}

}