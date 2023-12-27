package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.dao.loginDaoimpl_t;
import com.example.service.loginServiceImpl;
import com.interf.loginDao;
import com.interf.loginService;

@Configuration
public class config {
	@Bean
	public loginDao loginDao() {
		return new loginDaoimpl_t();
	}
	
	@Bean
	public loginService loginService() {
		return new loginServiceImpl();
	}
	
	

}
