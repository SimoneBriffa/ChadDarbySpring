package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class DeleteDemo {

	public static void main(String[] args) {
		
		//1 - create session factory
		
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
					
			//start a transaction
			
			session.beginTransaction();
			
			//get instructor by primary key / id
			
			int theId = 1;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			//commit transaction
			
			System.out.println("Found instructor: " + tempInstructor);
			
			session.delete(tempInstructor);
			//eliminerà anche la riga relativa nell'altra tabella
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally {
			factory.close();
		}
	}

}
