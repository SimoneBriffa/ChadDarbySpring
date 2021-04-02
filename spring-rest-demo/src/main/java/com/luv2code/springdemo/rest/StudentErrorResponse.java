package com.luv2code.springdemo.rest;

/*in caso di eccezione, come per esempio la richiesta di uno studente che non esiste
 * poichè avente un id inesistente, vogliamo trattare opportunatamente l'eccezione
 * lanciandola in formato JSON. A tal fine va creata una classe con i relativi
 * campi che formeranno i dati di base dell'eccezione
 */

public class StudentErrorResponse {
	
	private int status;  //404
	private String message;
	private long timeStamp;
	
	public StudentErrorResponse() {
		
	}

	public StudentErrorResponse(int status, String message, long timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
}
