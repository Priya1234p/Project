package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.binding.User;

@Controller
public class UserController {
	
	// http://localhost:8080/
	
	
	@GetMapping("/")
	public String loadForm() {
		
		return "form";
	}
	@PostMapping("/user")
	public String handlePostButton(User user, Model model) {
		System.out.println(user);
		model.addAttribute("msg", "user is saved");
		return "index";
      
	}

}
