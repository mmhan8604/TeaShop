package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.interf.loginService;
import com.example.interf.signUpService;
import com.example.interf.SetShopInfoSerivice;
import com.example.interf.frontStageService;
import com.example.service.SetShopInfoSeriviceImpl;



import com.example.service.loginServiceImpl;
import com.example.service.signUpServiceImpl;

@Configuration
public class config {
	
	
	@Bean
	
	public loginService lis() {
		return new loginServiceImpl();
	}
	
	@Bean
	public signUpService sus() {
		return new signUpServiceImpl();
	}
	
	
	
	@Bean
	public SetShopInfoSerivice ssis() {
		return new SetShopInfoSeriviceImpl(); 
	}
	
	

}
