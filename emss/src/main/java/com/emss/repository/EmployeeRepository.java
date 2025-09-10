package com.emss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emss.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
