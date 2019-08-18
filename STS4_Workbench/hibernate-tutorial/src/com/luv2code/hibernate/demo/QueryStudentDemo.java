package com.luv2code.hibernate.demo;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class QueryStudentDemo {

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
			// start a transaction
			System.out.println("Begin Transaction...");
			session.beginTransaction();
			
			// query the student(s) object
			TypedQuery<Student> q = session.createQuery("from Student", Student.class);
			List<Student> listOfStudents = q.getResultList();
			
			System.out.println("List out all Students : ");
			printListOfStudents(listOfStudents);
			
			// display the list of students where last name is Federio
			q = session.createQuery("from Student s where s.lastName='Federio'", Student.class); 
			listOfStudents = q.getResultList();
			
			System.out.println("List out all Students where last name is Federio");
			printListOfStudents(listOfStudents);
			
			// display the list of students with first name is Mikey and last name is Lupos
			q = session.createQuery("from Student s where s.firstName='Mikey' AND s.lastName='Lupos'", Student.class);
			listOfStudents = q.getResultList();
			
			System.out.println("List out all Students where firstname,lastname = Mikey,Lupos");
			printListOfStudents(listOfStudents);
			
			// display the list of students where email address ends with .com
			q = session.createQuery("from Student s where s.email LIKE '%lupos@email.com'", Student.class);
			listOfStudents = q.getResultList();
			
			System.out.println("List out all Students where email address ends with 'lupos@email.com'");
			printListOfStudents(listOfStudents);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Transaction Committed...");
			
		}
		finally {
			factory.close();
		}

	}

	private static void printListOfStudents(List<Student> listOfStudents) {
		int i = 0;
		// display the list of students
		for (Student student : listOfStudents) {
			i++;
			System.out.println("Student (" + i + ") "  + student);
		}
	}

}
