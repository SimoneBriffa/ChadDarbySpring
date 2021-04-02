package com.luv2code.jackson.json.demo;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Driver2 {

	public static void main(String[] args) {
		
		
		
		try{
				
			//create object mapper
			ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
			
			
			List<Student> studentList = mapper.readValue(new File("data/sample-lite.json"),
								new TypeReference<List<Student>>(){});

			//studentList = Arrays.asList(mapper.readValue(new File("data/sample-lite.json"), Student[].class));
		
			 
			for(Student temp: studentList) 
				System.out.println(temp.toString());
				
				mapper.writeValue(new File("data/write-data.json"), studentList);
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
