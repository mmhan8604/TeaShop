package com.example.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


import com.interf.loginDao;
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
		String r= dao.getPassword(clientAccount);
		
		if(r==null) {
			return 1;
		} else {
			Boolean check= checkPassword(r);
			if (check==false) {
				return 2;
			} else {
				return 0;
			}
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
