package com.luv2code.hibernate.demo;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class DeleteStudentDemo {

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
			int studentId = 6; // Mikey1 Lupos1
			// start a transaction
			System.out.println("Start transaction...");
			session.beginTransaction();

			// query the student(s) object
			TypedQuery<Student> q = session.createQuery("from Student", Student.class);
			List<Student> listOfStudents = q.getResultList();
			
			System.out.println("List out all Students : Before Updating all emails");
			printListOfStudents(listOfStudents);
			
			//retrieve the Saved student's record based on the primary key
			System.out.println("Key of student to get : " + studentId);

			Student getStudent = session.get(Student.class, studentId);
			
			System.out.println("Retrieved student details : Before Update...");
			System.out.println("               Id         : " + getStudent.getId());
			System.out.println("               First Name : " + getStudent.getFirstName());
			System.out.println("               Last  Name : " + getStudent.getLastName());
			System.out.println("               Email      : " + getStudent.getEmail());
			
			System.out.println("Deleting student Id=6 first/lastname : " + getStudent.getFirstName() + "/"+ getStudent.getFirstName());
			System.out.println("                               email : " + getStudent.getEmail());
			session.delete(getStudent);

			System.out.println("Retrieved student details : After  Update...");
			System.out.println("               Id         : " + getStudent.getId());
			System.out.println("               First Name : " + getStudent.getFirstName());
			System.out.println("               Last  Name : " + getStudent.getLastName());
			System.out.println("               Email      : " + getStudent.getEmail());
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Transaction committed...");

			// create a Session
			session = factory.getCurrentSession();
			
			// start a transaction
			System.out.println("Start transaction...");
			session.beginTransaction();

			// query the student(s) object
			q = session.createQuery("from Student", Student.class);
			listOfStudents = q.getResultList();
			
			System.out.println("List out all Students : After deleting record 6");
			printListOfStudents(listOfStudents);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Transaction committed...");

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
