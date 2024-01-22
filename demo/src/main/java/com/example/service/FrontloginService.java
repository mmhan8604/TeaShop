package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.classes.FrontLoginClasses;

@Service
public class FrontloginService {

	public int getauth(FrontLoginClasses loginInfo) {
		String name = loginInfo.getDisplayName();
		String email = loginInfo.getEmail();
		String provider = loginInfo.getProviderId();
		String loginMethod = loginInfo.getLoginMethod();
		Boolean emailVerified = loginInfo.getEmailVerified();
		
		if (emailVerified&&provider.equals("firebase")) {
			return 1;
		}else if(loginMethod.equals("password")) {
			return 2;
		}
		else {
			return 0;
		}
		
	}
}
