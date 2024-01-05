package com.example.service;

import java.util.HashMap;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


import com.example.repository.signUpDao;

import com.interf.signUpService;

@Component
@Primary
public class signUpServiceImpl implements signUpService{
	
	@Autowired
	signUpDao dao;
	
	HashMap<String,String > sData;

	@Override
	public void setsData(HashMap<String, String> sData) {
		this.sData = sData;
	}
	
	@Override
	public int create() {
		if(check()) {
			
			
			String beBrc=BCrypt.hashpw(sData.get("password"), BCrypt.gensalt());
			
			int a= dao.create(sData.get("account"), beBrc, sData.get("name"), sData.get("phone"), sData.get("email"));
			if (a>0) {
					return 0;
				}else {
					return 2;
			}
//			create(String account,String password,String name, String phone, String email )
		}else {
			return 1;
		}
	}
	
	public boolean check() {
		if(dao.findByAccount(sData.get("account")).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	

}
