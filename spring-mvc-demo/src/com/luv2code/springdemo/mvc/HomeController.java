package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping("/") 
	//la slash significa che andrà a cercare a partire dalla root (fa riferimento alla barra di ricerca web)
	public String showPage() {
		return "main-menu";  
		/*il file xml, allo step 5 contiene un bean che definisce prefisso e suffisso per 
		il percorso completo di una pagina */
	}

}

