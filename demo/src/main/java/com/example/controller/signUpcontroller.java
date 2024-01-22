package com.example.controller;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.interf.signUpService;

@RestController
public class signUpcontroller {
	
	@Autowired
	private signUpService ss;
	
	@PostMapping("/signup")
	public String signup(@RequestBody String data) {
		
		JSONObject jo=new JSONObject(data);
		
		
		
		int check= ss.create((HashMap)(jo.toMap()));
		if (check==0) {
			return"ok";
		}else {
			return"sign_fail";
		}
		
		
	}
	

}
