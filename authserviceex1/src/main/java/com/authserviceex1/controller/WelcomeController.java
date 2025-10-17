package com.authserviceex1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/welcome") // we use this to call this class
public class WelcomeController {
	
	// localhost:8080/api/v1/welcome/hello
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	// localhost:8080/api/v1/welcome/hi
	@GetMapping("/hi")
	public String hi() {
		return "hi";
	}

}
