package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class EagerLazyDemo {

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
			
			int theId = 4;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("The instructor: " + tempInstructor);
			
			//System.out.println("Courses: " + tempInstructor.getCourses());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			session.close();
			
			/*impostando la fetch a LAZY e richiedendo la stampa 
			 * dei corsi invocando il getcourses() dopo la chiusura della sessione,
			 * lancia un'eccezione... invece richiedendo il get prima della chiusura
			 * permette di stamparli anche dopo la chiusura della sessione (naturalmente
			 * invocando nuovamente il get).
			 * Secondo questa logica, usando la fetch EAGER possiamo stampare quello
			 * che vogliamo dopo la chiusura perchè viene caricato tutto
			 */
			
		}finally {
		
			factory.close();
		}
	}

}
