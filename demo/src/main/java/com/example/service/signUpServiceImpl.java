package com.example.service;

import java.util.HashMap;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.example.interf.signUpService;
import com.example.repository.signUpDao;



public class signUpServiceImpl implements signUpService{
	
	@Autowired
	signUpDao dao;
	
	

	
	
	@Override
	public int create(HashMap<String,String> sData) {
		if(check(sData.get("email"))) {
			
			
			String beBrc=BCrypt.hashpw(sData.get("password"), BCrypt.gensalt());
			
			int changeCol= dao.create( sData.get("shopName"),beBrc, sData.get("name"), sData.get("phone"), sData.get("email") );
			if (changeCol>0) {
					return 0;
				}else {
					return 2;
			}

		}else {
			return 1;
		}
	}
	
	private boolean check(String email) {
		if(dao.findByEmail(email).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	

}
