package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.example.service.loginServiceImpl;
import com.example.service.signUpServiceImpl;

import com.interf.loginService;
import com.interf.signUpService;

@Configuration
public class config {
	
	
	@Bean
	public loginService loginServicei() {
		return new loginServiceImpl();
	}
	
	@Bean
	public signUpService signUpServicei() {
		return new signUpServiceImpl();
	}
	
	

}
