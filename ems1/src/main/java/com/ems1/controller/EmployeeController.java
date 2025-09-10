package com.ems1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ems1.dto.EmployeeDto;
import com.ems1.entity.Employee;
import com.ems1.service.EmployeeService;



@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// http://localhost:8080/view      --> this url will basically call the given below method through server
	
	
	@RequestMapping("/view")
	public String viewRegisterEmp() {
		return "registration"; // this is act like a request dispatcher
	}
	
	
	@RequestMapping("/saveReg")
	public String getRegistrationData(EmployeeDto employeeDto, Model model) {
		employeeService.saveEmployeeDetails(employeeDto);
		model.addAttribute("msg", "record saved !!");
		return "registration";
		
		
	}
	
	@RequestMapping("/saveRegistration")
	public String getDataUsingRequestParam(
			 @RequestParam String firstName,
			 @RequestParam String lastName,
			 @RequestParam("emailId") String email,
			 @RequestParam String mobile
			) {
		
		employeeService.register(firstName,lastName,email,mobile);
		return "employee";
	}
	
	@RequestMapping("/viewRegistration")
	public String viewRegister() {
		return "employee";//--> RequestDispatcher
	}
	
	@RequestMapping("/listRegistrations")
	public String viewRegistrations(ModelMap model) {
		List<Employee> employees = employeeService.getRegistrations();
		model.addAttribute("employees",employees);
		return "list_registrations";//--> RequestDispatcher
	
	}


}
