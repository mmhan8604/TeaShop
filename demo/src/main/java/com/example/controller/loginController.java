package com.example.controller;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.interf.loginService;


@RestController
public class loginController {
	@Autowired 
	
	private loginService ls;
	
	
	@PostMapping("/login")
	public String login(@RequestBody String data) {
		
		JSONObject jo=new JSONObject(data);
		
		
		ls.setClientAccount(jo.get("email").toString());
		ls.setClientPassword(jo.get("password").toString());
		
				
		int state= ls.checkAccount();
		
		if(state==0) {
			return "login_success";
		} else {
			return "login_failed";
		}
		
		
	}
	

	

}
