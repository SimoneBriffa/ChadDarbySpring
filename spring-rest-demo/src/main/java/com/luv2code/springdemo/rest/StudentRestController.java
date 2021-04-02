package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//il seguente tag PostConstruct permette di caricare la lista una volta per tutta
	
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Simone", "Briffa"));
		theStudents.add(new Student("Dario", "Fortuna"));
		theStudents.add(new Student("Salvo", "Ilacqua"));
		theStudents.add(new Student("Carlo", "Branchina"));
	}
	
	//creiamo un metodo che usi un link web per ottenere uno specifico studente
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//qui introduciamo la gestione dell'eccezione
		
				if(studentId >= theStudents.size() || studentId < 0) {
					throw new StudentNotFoundException("Student id not found - " + studentId);
				}
		
		return theStudents.get(studentId);
		
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return theStudents;
	}
	
	
}
