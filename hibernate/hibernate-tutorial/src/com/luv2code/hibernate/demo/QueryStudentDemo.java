package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//1 - create session factory
		
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		//2 - create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			
			session.beginTransaction();
			
			//--------------------LISTA STUDENTI
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			//sarebbe SELECT * FROM students
			

			for(Student student: theStudents)
				System.out.println(student);
			System.out.println("+++++++++++++++++++++++++++++++++++++");
			
			//--------------------UNO STUDENTE IN PARTICOLARE
			
			theStudents = session.createQuery("from Student s where s.lastName='Briffa'").getResultList();
			
			for(Student student: theStudents)
				System.out.println(student);
			System.out.println("+++++++++++++++++++++++++++++++++++++");
			
			//--------------------UNO STUDENTE IN PARTICOLARE CON ALTERNATIVA
			
			theStudents = session.createQuery("from Student s where s.lastName='Briffa'"
					+ " OR s.firstName='Claudia'").getResultList();
			
			for(Student student: theStudents)
				System.out.println(student);
			System.out.println("+++++++++++++++++++++++++++++++++++++");
			
			//--------------------Studenti la cui mail contiene una particolare sequenza di caratteri
			
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'")
								.getResultList();
			
			for(Student student: theStudents)
				System.out.println(student);
			System.out.println("+++++++++++++++++++++++++++++++++++++");
			
			
			
			//commit transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
	}

}
