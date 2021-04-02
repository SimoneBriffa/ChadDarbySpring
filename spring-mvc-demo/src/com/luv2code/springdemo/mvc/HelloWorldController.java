package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
//questo è utile quando più di un controller richiede la stessa pagina
//in questo caso showForm (richiesta anche da SillyController)
public class HelloWorldController {
	
	
	//need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//add new controller method to read form data and add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		
		//1 - read the request parameter from the html form
		
		String theName = request.getParameter("studentName");
		
		//2 - convert the data to all caps
		
		theName = theName.toUpperCase();
		
		//3 - create the message
		
		String message = "From controller: " + theName;
		
		//4 - add message to the model
		
		model.addAttribute("message", message);
		
		return "helloworld";
		
	}
	
	/*oppure, invece di spacchettare la richiesta nel corpo della funzione, possiamo farlo
	nei parametri */
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		//1 - convert the data to all caps
		
		theName = theName.toUpperCase();
		
		//2 - create the message
		
		String message = "From @RequestParam: " + theName;
		
		//3 - add message to the model
		
		model.addAttribute("message", message);
		
		return "helloworld";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
