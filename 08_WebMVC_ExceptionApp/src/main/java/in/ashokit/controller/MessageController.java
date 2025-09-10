package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MessageController {
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		String msg="Welcome to Ashok It...";
		
			int i=10/0;
	
		return msg;
	}
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		String msg="Good Evening";
		return msg;
	}
	
}
