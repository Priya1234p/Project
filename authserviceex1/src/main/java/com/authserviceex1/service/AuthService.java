package com.authserviceex1.service;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.authserviceex1.dto.APIResponse;
import com.authserviceex1.dto.UserDto;
import com.authserviceex1.entity.User;
import com.authserviceex1.repository.UserRepository;

@Service
public class AuthService {

	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;
	
	public AuthService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public APIResponse<String> register(UserDto dto){
		
		if (userRepository.existsByUsername(dto.getUsername())) {
			APIResponse<String> response = new APIResponse<>();
			response.setMessage("Registration Failed");
			response.setStatus(500);
			response.setData("User with username exists");
			return response;
		}
		
		if (userRepository.existsByEmail(dto.getEmail())) {
			APIResponse<String> response = new APIResponse<>();
			response.setMessage("Registration Failed");
			response.setStatus(500);
			response.setData("User with username exists");
			return response;
		}
		
		User user = new User();
		BeanUtils.copyProperties(dto, user);
		
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		userRepository.save(user);
		
		APIResponse<String> response = new APIResponse<>();
		response.setMessage("Registration Done");
		response.setStatus(201);
		response.setData("User is registered");
		
		return response;
	}

}
