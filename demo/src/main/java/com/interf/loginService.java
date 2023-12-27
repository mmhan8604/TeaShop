package com.interf;

import java.util.HashMap;

public interface loginService {
	
	public void setClientAccount(String clientAccount) ;
	public void setClientPassword(String clientPassword);
	int checkAccount();
	boolean checkPassword(String r);
	
}
