package in.ashokit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MessageController {
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		
		return "Welcome to Ashok IT...";
		
	}
	@GetMapping("/greet")
	public String getGreetMsg() {
		
		return "Good evening";
		
	}

}
