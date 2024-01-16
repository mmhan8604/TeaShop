package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.example.interf.loginService;
import com.example.interf.signUpService;
import com.example.interf.SetShopInfoSerivice;
import com.example.interf.frontStageService;
import com.example.service.SetShopInfoSeriviceImpl;
import com.example.service.frontStageServiceImpl_test;


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
		return new frontStageServiceImpl_test();
	}
	
	@Bean
	public SetShopInfoSerivice ssis() {
		return new SetShopInfoSeriviceImpl(); 
	}
	
	

}
