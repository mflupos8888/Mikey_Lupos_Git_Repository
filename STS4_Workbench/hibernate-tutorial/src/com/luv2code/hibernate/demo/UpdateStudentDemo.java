package com.luv2code.hibernate.demo;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class UpdateStudentDemo {

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
			int studentId = 2;
			// start a transaction
			System.out.println("Start transaction...");
			session.beginTransaction();
			
			//retrieve the Saved student's record based on the primary key
			System.out.println("Key of student to get : " + studentId);

			Student getStudent = session.get(Student.class, studentId);
			
			System.out.println("Retrieved student details : Before Update...");
			System.out.println("               Id         : " + getStudent.getId());
			System.out.println("               First Name : " + getStudent.getFirstName());
			System.out.println("               Last  Name : " + getStudent.getLastName());
			System.out.println("               Email      : " + getStudent.getEmail());
			
			System.out.println("Update student first name from : " + getStudent.getFirstName());
			getStudent.setFirstName("Coco Monster");
			System.out.println("                            to : " + getStudent.getFirstName());

			System.out.println("Retrieved student details : After  Update...");
			System.out.println("               Id         : " + getStudent.getId());
			System.out.println("               First Name : " + getStudent.getFirstName());
			System.out.println("               Last  Name : " + getStudent.getLastName());
			System.out.println("               Email      : " + getStudent.getEmail());
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Transaction committed...");
			
			// create another Session
			session = factory.getCurrentSession();
			
			// start another transaction
			System.out.println("Start transaction...");
			session.beginTransaction();
			
			// query the student(s) object
			TypedQuery<Student> q = session.createQuery("from Student", Student.class);
			List<Student> listOfStudents = q.getResultList();
			
			System.out.println("List out all Students : Before Updating all emails");
			printListOfStudents(listOfStudents);
			
			// update email for all Students
			System.out.println("Updating email of all students to 'allstudents@email.com'");
			session.createQuery("update Student set email='allmystudents@email.com'").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Transaction committed...");

			// create another Session
			session = factory.getCurrentSession();
			
			// start another transaction
			System.out.println("Start transaction...");
			session.beginTransaction();
			
			// query the student(s) object
			q = session.createQuery("from Student", Student.class);
			listOfStudents = q.getResultList();
			
			System.out.println("List out all Students : After  Updating all emails");
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
