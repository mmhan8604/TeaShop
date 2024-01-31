package com.example.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Testcontroller {
	
	@GetMapping("/test111")
	public String test(HttpServletRequest request) {
		 String domain = request.getServerName();
		 return domain;
	}
}
