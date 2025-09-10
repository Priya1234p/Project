package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	//http://localhost:8080/celebrate?name=david 
	
	@GetMapping("/celebrate")
	public ModelAndView getWelcomeMsg(@RequestParam String name) {
		String msgTxt = " good evening "+name;
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msgTxt);
		mav.setViewName("index");
		return mav;
	}
	
	//http://localhost:8080/congo?name=david
	
	@GetMapping("/congo")
	public String getCongoMsg(@RequestParam String name, Model model) {
		
		model.addAttribute("msg", name+ ", Good Evening ...!!");
		return "index";
	}

}
