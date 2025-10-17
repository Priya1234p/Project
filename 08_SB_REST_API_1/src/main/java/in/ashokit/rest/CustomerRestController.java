package in.ashokit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Customer;

@RestController
public class CustomerRestController {
	
	@GetMapping("/customer")
	public Customer getCustomer() {
		Customer c = new Customer();
		c.setName("karl");
		c.setGender("Male");
		c.setEmail("karl@gmail.com");
		
		return c;
	}
	@PostMapping( value="/customerr" ,consumes= {"application/xml", "application/json"}, produces= {"text/plain"})
	public ResponseEntity<String> addCustomer(Customer customer){
		System.out.println(customer);
		
		return new ResponseEntity<>("Welcome message..",HttpStatus.OK);
	}

}
