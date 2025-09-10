package com.emss.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emss.Dto.EmployeeDto;
import com.emss.entity.Employee;
import com.emss.service.EmployeeService;
import com.emss.util.EmailService;

@Controller
public class EmployeeController {
	
	
	private EmployeeService employeeService;
	private EmailService emailService;
	
	
	public EmployeeController(EmployeeService employeeService, EmailService emailService) {
		this.employeeService = employeeService;
		this.emailService = emailService;
	}

	//http://localhost:8080/view
	
	@RequestMapping("/view")
	public String viewRegisterEmp() {
		return "registration";
	}
	
	@RequestMapping("/saveReg")
	public String getRegistrationData( EmployeeDto employeeDto, Model model) {
		
		//employeeService.saveEmployeeDetails(employeeDto);
		model.addAttribute("msg","record is saved!!");
		emailService.sendEmail(employeeDto.getEmail(), "Test", "Registration done!!");
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
	public String viewRegistrations(ModelMap model)  {
			//List<Employee> employees = employeeService.getRegistrations();
			//model.addAttribute("employees",employees);
			return "list_registrations";//--> RequestDispatcher
		}
	
	
	@RequestMapping("/deleteEmployee")
	public String deleteRegistrations(@RequestParam long id, ModelMap model)  {//@RequestParam is capable of fetching value from url
		employeeService.deleteRegistrationById(id);
		
		//List<Employee> employees = employeeService.getRegistrations();
		//model.addAttribute("employees",employees);
		return "list_registrations";//--> RequestDispatcher
		}
	
	
	@RequestMapping("/getEmployee")
	public String getRegistrations(@RequestParam long id, ModelMap model)  {//@RequestParam is capable of fetching value from url
		Employee employee = employeeService.getRegistrationById(id);
		 model.addAttribute("employee", employee);
		 return "update_registration";
	
		}
	
	@RequestMapping("/updateReg")
	public String updateEmployeeData(Employee employee, ModelMap model) {
		employeeService.updateEmployee(employee);
		
		//List<Employee> employees = employeeService.getRegistrations();
		//model.addAttribute("employees",employees);
		return "list_registrations";//--> RequestDispatcher
	}
	

}
