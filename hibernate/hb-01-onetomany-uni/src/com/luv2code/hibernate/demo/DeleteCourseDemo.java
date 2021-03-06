package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		//1 - create session factory
		
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId = 2;
			Course tempCourse = session.get(Course.class, theId);
			
			session.delete(tempCourse);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}catch(NullPointerException e) {
			
			System.out.println("No instructor for this id");
			
			/*MOLTO IMPORTANTE
			 * 
			 * Questo modo di gestire le eccezioni ? molto utile per la JSP, 
			 * infatti nel caso di una richiesta per un elemento che non esiste, basta
			 * acchiappare la NullPointerException e dirottarla ad un'altra pagina JSP,
			 * invece che andare alla pagina di errore
			 * 
			 */
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
