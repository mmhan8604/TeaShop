package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.classes.FrontLoginClasses;
import com.example.service.FrontloginService;

@Controller
public class FrontloginController {
	
	@Autowired
	FrontloginService frontloginService;
	
	@PostMapping("/getauth")
	public String getauth(@RequestBody FrontLoginClasses loginInfo) {
		System.out.println(loginInfo);
		return "";
	}
	
}
