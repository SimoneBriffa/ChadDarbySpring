package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class FetchJoinDemo {

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
			
			//altro approccio...
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses where i.id=:theInstructorID", Instructor.class);
			
			query.setParameter("theInstructorId", theId);
			
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("The instructor: " + tempInstructor);
			

			//commit transaction
			session.getTransaction().commit();
		
			session.close();
			
			/*stampiamo i corsi dopo la chiusura della sessione, quindi
			 * questo presume che la fetch sia impostata a EAGER
			 */
			
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			
		}finally {
		
			factory.close();
		}
	}

}
