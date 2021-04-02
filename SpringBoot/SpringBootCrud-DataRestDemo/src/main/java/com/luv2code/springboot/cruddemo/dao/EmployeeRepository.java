package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springboot.cruddemo.entity.Employee;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	/*di base, Spring Boot crea i controller impostando il primo generic
	 * (in questo caso Employee) con prima lettera minuscola e aggiungendo
	 * una s come suffisso. Questo sarebbe sbagliato nel caso di plurali
	 * irregolari come Person -> People.
	 * Questo tag ci consente dunque di decidere quale debba essere il plurale
	 */
	
}

