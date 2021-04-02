package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*questa classe permettera a qualsiasi numero di controller di utilizzare la gestione
 * delle eccezioni create, evitando di andare a crearla specificatamente per ognuno
 */


@ControllerAdvice //distribuisce tra i controller il gestore eccezioni
public class StudentRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
		
		//creare un'istanza di StudentErrorResponse
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); //404
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	/*aggiungiamo un altro gestore eccezioni nel caso venga richiesta una stringa
	come id dello studente */
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e){
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value()); //400
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}

}
