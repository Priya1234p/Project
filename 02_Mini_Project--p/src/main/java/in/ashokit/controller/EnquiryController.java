package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnquiryController {
	
	@GetMapping("/dashboard")
	public String dashboardPage() {
		return "dashboard";
	}
	
	@GetMapping("/add-enquiry")
	public String addEnquiryPage() {
		return "add-enquiry";
	}

	@GetMapping("/view-enquires")
	public String viewEnquiriesPAge() {
		return "view-enquires";
	}


}
