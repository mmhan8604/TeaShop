package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.interf.frontStageService;
import com.example.interf.loginService;
import com.example.interf.signUpService;
import com.example.service.frontStageServiceTest;
import com.example.service.loginServiceImpl;
import com.example.service.signUpServiceImpl;

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
	
	@Bean
	public frontStageService fss() {
		return new frontStageServiceTest();
	}
	
	

}
