package com.emss.rest;
 
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emss.Dto.APIResponse;
import com.emss.entity.Employee;
import com.emss.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	//http://localhost:8080/api/v1/employee
	@PostMapping("/save")
	public ResponseEntity<APIResponse<Employee>> saveEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.saveEmployeeDetails(employee);
		APIResponse<Employee> response = new APIResponse<>();
		response.setMessage("Record is saved !!");
		response.setStatus(201);
		response.setData(emp);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	//http://localhost:8080/api/v1/employee/delete?id=1
	@DeleteMapping("/delete")
	public ResponseEntity<APIResponse<String>> deleteEmployee(
			@RequestParam long id
			){
		employeeService.deleteRegistrationById(id);
		
		APIResponse<String> response = new APIResponse<>();
		response.setMessage("Record is saved !!");
		response.setStatus(201);
		response.setData("Record with id: "+id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	//Path Param = http://localhost:8080/api/v1/employee/get/1
	@GetMapping("/get/{id}")
	public ResponseEntity<APIResponse<Employee>> findEmployeeById(
			
			 @PathVariable long id
			 
			){
		Employee employee = employeeService.getEmployeeById(id);
		
		APIResponse<Employee> response = new APIResponse<>();
		response.setMessage("Record is saved !!");
		response.setStatus(201);
		response.setData(employee);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	//Path Param = http://localhost:8080/api/v1/employee/get-all?pageNo=0&pageSize=5
		@GetMapping("/get-all")
		public ResponseEntity<APIResponse<List<Employee>>> findEmployees(
				@RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo,
				@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
				@RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
				@RequestParam(value = "sortDir", required = false, defaultValue = "asc") String sortDir
				
				){
			
			List<Employee> employees = employeeService.getRegistrations(pageNo,pageSize, sortBy, sortDir);
			
			APIResponse<List<Employee>> response = new APIResponse<>();
			response.setMessage("Record is saved !!");
			response.setStatus(201);
			response.setData(employees);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		@PutMapping
		public ResponseEntity<APIResponse<String>> UpdateEmployee(
				@RequestBody Employee employee
				){
			employeeService.updateEmployee(employee);
			
			APIResponse<String> response = new APIResponse<>();
			response.setMessage("Done... !!");
			response.setStatus(201);
			response.setData("Updated!!!");
			
			return new ResponseEntity<>(response, HttpStatus.OK);

		}
	

}
