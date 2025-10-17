package com.emss.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emss.Dto.UserRequestDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	//http://localhost:8080/api/users/register
	@PostMapping("/register")
    public ResponseEntity<String> registerUser(
    		@Valid @RequestBody UserRequestDTO userRequestDTO,
    		BindingResult result
    		){
		if(result.hasErrors()) {
			return new ResponseEntity<String>(result.getFieldErrors().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("User Saved",HttpStatus.CREATED);
	}

}
