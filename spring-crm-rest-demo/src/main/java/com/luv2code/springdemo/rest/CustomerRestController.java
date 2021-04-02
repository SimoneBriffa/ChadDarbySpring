package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	//iniettare l'interfaccia del service
	
	@Autowired
	private CustomerService customerService;
	
	//mappatura per GET/ customers
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	/*mappatura per Get/customers/{customerId}
	preleviamo uno specifico customer */
	@GetMapping("/customers/{customerId}")
	private Customer getCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		/* nel caso in cui venga richiesto un id inesistente non viene lanciata
		 * la pagina di errore, perchè la funzione getCustomer prevede di ritornare
		 * null nel caso in cui si verifichi ciò. Jackson è progettato per
		 * lanciare una pagina vuota nel caso in cui abbia null.
		 * Se vogliamo che venga lanciata la pagina di errore allora
		 * è necessario stilare la classe che distrubuisca la 
		 * gestione dell'eccezione ai controller.
		 */
		
		if(theCustomer == null)
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		
		return theCustomer;
		
	}
	
	//mappatura per aggiungere un nuovo customer -> POST
	
		@PostMapping("/customers")
		public Customer addCustomer(@RequestBody Customer theCustomer) {
			
			//riceve in Request un Customer impacchettato in JSON
			
			/*impostato il id a 0, saveOrUpdate() nel DAO aggiungerà
			 * l'oggetto eliminando ogni possibilità 
			 * di confusione con l'aggiornamento */
			
			theCustomer.setId(0);
			customerService.saveCustomer(theCustomer);
			
			return theCustomer;
			
		}
		
	//mappatura per aggiornare una voce esistente -> PUT
		
		@PutMapping("/customers")
		public Customer updateCustomer(@RequestBody Customer theCustomer) {
			
			//qui il id viene specificato, quindi aggiorna
			
			customerService.saveCustomer(theCustomer);
			
			return theCustomer;
			
		}
		
	//mappatura per eliminare una voce -> DELETE
		
		@DeleteMapping("/customers/{customerId}")
		public String deleteCustomer(@PathVariable int customerId) {
			
			Customer tempCustomer = customerService.getCustomer(customerId);
			
			if(tempCustomer == null)
				throw new CustomerNotFoundException("Customer id not found - " + customerId);
			
			customerService.deleteCustomer(customerId);
			
			return "Deleted customer id - " + customerId;
		}

}
