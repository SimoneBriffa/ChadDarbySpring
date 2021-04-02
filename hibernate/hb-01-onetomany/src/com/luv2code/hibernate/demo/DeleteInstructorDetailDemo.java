package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

//eliminiamo contemporaneamente le due righe partendo dalla tabella associata

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		//1 - create session factory
		
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			//impostiamo l'id
			
			int theId = 4;
			
			//preleviamo il corrispondente oggetto
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//stampa i dettagli dell'oggetto
			
			System.out.println("Instructor details: " + tempInstructorDetail);
			
			System.out.println("The associated instructor: " + tempInstructorDetail.getInstructor());
			
			//eliminiamo
			
			session.delete(tempInstructorDetail);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}catch(NullPointerException e) {
			System.out.println("No instructor for this id");
		}finally {
			session.close();
			factory.close();
		}
	}

}
