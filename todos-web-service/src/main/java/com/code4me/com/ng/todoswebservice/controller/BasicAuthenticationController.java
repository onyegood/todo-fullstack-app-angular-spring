package com.code4me.com.ng.todoswebservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code4me.com.ng.todoswebservice.model.BasicAuthenticationBean;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/basicauth")
public class BasicAuthenticationController {
	@GetMapping
	public BasicAuthenticationBean basicAuthenticationBean() {
		return new BasicAuthenticationBean("Welcome to hello world software!");
	}
	
}
