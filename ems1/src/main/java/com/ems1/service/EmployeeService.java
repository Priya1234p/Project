package com.ems1.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems1.dto.EmployeeDto;
import com.ems1.entity.Address;
import com.ems1.entity.Employee;
import com.ems1.repository.AddressRepository;
import com.ems1.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AddressRepository addressRepository;
    
	
	public void saveEmployeeDetails(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);

		Address address = new Address();
		BeanUtils.copyProperties(employeeDto, address);
		
		

		employeeRepository.save(employee);
		addressRepository.save(address);
	}

	public void register(String firstName, String lastName, String email, String mobile) {
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setEmail(email);
		emp.setMobile(mobile);
		employeeRepository.save(emp);

	}

	public List<Employee> getRegistrations() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;

	}

}
