package in.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {
	@GetMapping("/balance")
	public String Balance() {
		return "your balance :: 7889.90  INR ";
		
	}
	
	@GetMapping("/transfer")
	public String amtTransfer() {
		return "Your aamount is transfered sucessfully";
		
	}
	
	@GetMapping("/login")
	public String login() {
		return "Login sucessfully";
		
	}
	
	@GetMapping("/contact")
	public String getContactINfo() {
		return "Contact us :: abc@gmail.com";
		
	}




}
