package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
public static void main(String[] args) {
		
		//1 - create session factory
		
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		//2 - create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//create three student objects
			
			System.out.println("Creating 3 student objects -> ");
			
			Student tempStudent1 = new Student("Simone", "Briffa", "simonebriffa@gmail.com");
			Student tempStudent2 = new Student("Dario", "Fortuna", "dariofortuna@gmail.com");
			Student tempStudent3 = new Student("Claudia", "Ferro", "claudiaferro@gmail.com");
			
			//start a transaction
			
			session.beginTransaction();
			
			//save the student object
			
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//commit transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
	}

}
