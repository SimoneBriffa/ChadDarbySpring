package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read JSON file and map/convert to java POJO
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			
			/*il sistema Jackson andrà a scomodare non i campi ma i setter */
			
			
			//print first name and last name 
			System.out.println("First name: " + theStudent.getFirstName());
			System.out.println("Last name: " + theStudent.getLastName());
			System.out.println("Address: " + theStudent.getAddress().getCity());
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
