package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	
	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String pass = "root";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection succesful");
			
		}catch(Exception e) {
			System.out.println("Connection failure");
			e.printStackTrace();
		}
		
	}

}
