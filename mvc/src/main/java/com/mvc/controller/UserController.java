package com.mvc.controller;

import org.springframework.web.bind.annotation.*;

import com.mvc.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getUserName(@PathVariable int id) {
        return service.getUserName(id);
    }
}
