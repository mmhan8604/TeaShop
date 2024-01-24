package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.classes.FrontLoginClasses;
import com.example.entity.Member;
import com.example.repository.MemberRepository;

@Service
public class FrontloginService {
	@Autowired
	MemberRepository memberRes;
	
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
	public boolean checkMember(String email,String shopId) {
		List<Member> members = memberRes.findByShopIdAndMail(shopId, email);
		if(!members.isEmpty()) {return true;}
		else {
			return false;
		}
		
	}
}
