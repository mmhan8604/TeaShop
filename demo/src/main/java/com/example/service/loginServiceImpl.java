package com.example.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.aop.loginException;
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
	
	@Override
	public int getShopId(String clientAccount) {
		List<shopInfo> fba= dao.findByEmail(clientAccount);
		
		if(!fba.isEmpty()) {
			return fba.get(0).getId();
		}else {
			 throw new loginException();
		}
			
	}

	

}
