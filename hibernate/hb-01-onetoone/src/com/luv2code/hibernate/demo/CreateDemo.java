package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class CreateDemo {

	public static void main(String[] args) {
		
		//1 - create session factory
		
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//1 - create objects
			
			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail(
					"http://www.luv2code.com/youtube", "Luv 2 code!");
			
			//2 - associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//3 -start a transaction
			
			session.beginTransaction();
			
			/*4 - save the instructor (this will also save InstructorDetail
			because of CascadeType.ALL */
			
			session.save(tempInstructor);
			
			
			//commit transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally {
			factory.close();
		}
	}

}
