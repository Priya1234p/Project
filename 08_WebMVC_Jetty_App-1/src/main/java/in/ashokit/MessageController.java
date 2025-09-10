package in.ashokit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {
	@GetMapping("/welcome")
	@ResponseBody // through that we can send direct response to UI 
	public String getWelcomeMsg() {
		return "Welcome to Ashok IT..";
		
	}
	
	@GetMapping("/greet")
	public String getGreetMsg(Model model) {
		model.addAttribute("msg", "Good evening");
		return "index";
		
	}

}
