package com.example.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.interf.loginDao;

@Component
@Repository
@Primary
public class loginDaoimpl_t implements loginDao{
	
	private String result;
	@Override
	public String getPassword(String account) {
		// TODO Auto-generated method stub
		try {
			result="12345";
			
			return result;
		} catch (Exception e) {
			return null;
		}
		
	}

}
