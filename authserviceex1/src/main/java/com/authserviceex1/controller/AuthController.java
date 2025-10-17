package com.authserviceex1.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authserviceex1.dto.APIResponse;
import com.authserviceex1.dto.LoginDto;
import com.authserviceex1.dto.UserDto;
import com.authserviceex1.service.AuthService;
import com.authserviceex1.service.JwtService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	private AuthService authService;
	private JwtService jwtService;

	private AuthenticationManager authenticationManager;

	public AuthController(AuthService authService, AuthenticationManager authenticationManager,JwtService jwtService) {
		this.authService = authService;
		this.authenticationManager = authenticationManager;
		this.jwtService=jwtService;
	}


	@PostMapping("/register/doctor")
	public ResponseEntity<APIResponse<String>> registerDoctor(@RequestBody UserDto userDto) {
		userDto.setRole("ROLE_DOCTOR");
		APIResponse<String> response = authService.register(userDto);
		// Return Status dynamically based on response.getStatus()
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/register/patient")
	public ResponseEntity<APIResponse<String>> registerUser(@RequestBody UserDto userDto) {
		userDto.setRole("ROLE_PATIENT");
		APIResponse<String> response = authService.register(userDto);
		// Return Status dynamically based on response.getStatus()
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	
	//http://localhost:8080/api/v1/auth/login

	@PostMapping("/login")
	public ResponseEntity<APIResponse<String>> loginCheck(@RequestBody LoginDto loginDto) {

		APIResponse<String> response = new APIResponse<>();

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDto.getUsername(),
				loginDto.getPassword());
		try {
			 Authentication authenticate1 = authenticationManager.authenticate(token);
			 
			 if(authenticate1.isAuthenticated()) {
				 String jwtToken = jwtService.generateToken(loginDto.getUsername());
				 response.setMessage("Login Sucessful");
				 response.setStatus(200);
				 response.setData(jwtToken);
				 return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 response.setMessage("Failed");
		 response.setStatus(401);
		 response.setData("Un-Authorized Access");
		 return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
	 }

}
