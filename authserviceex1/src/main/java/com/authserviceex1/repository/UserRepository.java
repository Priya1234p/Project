package com.authserviceex1.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.authserviceex1.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
	User findByUsername(String username);
	User findByEmail(String email);
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
}
