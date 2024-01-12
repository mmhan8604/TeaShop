package com.example.controller;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.interf.loginService;

import com.example.aop.loginException;


import jakarta.servlet.http.HttpSession;



@RestController
public class loginController {
	@Autowired 
	
	private loginService ls;
	
	
	@PostMapping("/login")
	public String login(HttpSession session, @RequestBody String data) {
		
		try {
			
		} catch (loginException e) {
			System.out.println("t");
		}
		
		JSONObject jo=new JSONObject(data);
		
		
		ls.setClientAccount(jo.get("email").toString());
		ls.setClientPassword(jo.get("password").toString());
		
				
		int state= ls.checkAccount();
		
		if(state==0) {
			
			session.setAttribute("email", jo.get("account").toString());
			return "login_success";
		} else {
			return "login_failed";
		}
		
		
	}
	

	

}
