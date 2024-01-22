package com.example.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;



import com.example.entity.shopInfo;
import com.example.interf.loginService;
import com.example.repository.loginDao;



public class loginServiceImpl implements loginService{

	@Autowired 
	private loginDao dao;
	


	@Override
	public int checkAccount(String clientAccount,String clientPassword) {
		List<shopInfo> fba= dao.findByEmail(clientAccount);
		
		if(fba.isEmpty()) {
			return 1;
		} else if(BCrypt.checkpw(clientPassword, fba.get(0).getPassword())){
			return 0;
		}else {
			return 2;
		}
		
		
	}

	

}
