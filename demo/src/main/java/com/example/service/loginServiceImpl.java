package com.example.service;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.dao.loginDao;
import com.example.entity.shopInfo;
import com.interf.loginService;

@Component
@Primary
public class loginServiceImpl implements loginService{

	@Autowired 
	private loginDao dao;
	
	private String clientAccount;
	private String clientPassword;
	
	public loginServiceImpl( ) {
		
	}
	
	
	
	


	@Override
	public void setClientAccount(String clientAccount) {
		this.clientAccount = clientAccount;
	}



	


	@Override
	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}



	@Override
	public int checkAccount() {
		List<shopInfo> fba= dao.findByAccount(clientAccount);
		
		if(fba.isEmpty()) {
			return 1;
		} else if(fba.get(0).getPassword().equals(clientPassword)){
			return 0;
		}else {
			return 2;
		}
		
		
	}

	@Override
	public boolean checkPassword(String r) {
		if (r.equals(clientPassword)) {
			return true;
		}else {
			return false;
		}
		
	}

}
