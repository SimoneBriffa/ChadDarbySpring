package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;


public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//1 - create session factory
		
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();		
			
			//get the course
			int theId = 3;
			Course tempCourse = session.get(Course.class, theId);
			
			//print the course
			System.out.println(tempCourse);
			
			//print course's reviews
			System.out.println(tempCourse.getReviews());
			
			//cancelliamo il corso: la reazione a cascata impostata su ALL eliminirÓ le reviews
			session.delete(tempCourse);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			
			session.close();
			factory.close();
		}
	}

}
