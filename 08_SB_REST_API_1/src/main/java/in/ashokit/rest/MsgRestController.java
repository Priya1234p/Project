package in.ashokit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	
	public MsgRestController() {
		System.out.println("MsgRestController::constructor");
	}
	
	//http://localhost:8080/welcome
	
	@GetMapping("/welcome")
	public ResponseEntity<String> getWelcomeMsg(){
		String msg ="Welcome to Ashok IT";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	@GetMapping("/greet")
	public String getGreetMsg() {
		String msg = "Good Evening";
		return msg;
	}

}
