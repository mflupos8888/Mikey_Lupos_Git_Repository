package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Mikey1", "Lupos1", "mikey1lupos1@email1.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student object into MySQL student table...");
			System.out.println("Saving student : " + tempStudent);
			session.save(tempStudent);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Update committed...");
			
			//find out the student's primary key
			System.out.println("Saved student's key : " + tempStudent.getId());
			
			// get a new session
			session = factory.getCurrentSession();
			
			// start a new transaction
			session.beginTransaction();
			
			//retrieve the Saved student's record based on the primary key
			System.out.println("Key of student to get : " + tempStudent.getId());
			Student getStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Retrieved student details : ");
			System.out.println("               Id         : " + getStudent.getId());
			System.out.println("               First Name : " + getStudent.getFirstName());
			System.out.println("               Last  Name : " + getStudent.getLastName());
			System.out.println("               Email      : " + getStudent.getEmail());
			
		}
		finally {
			factory.close();
		}

	}

}
