package com.mvc_unit_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc_unit_test.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	

}
