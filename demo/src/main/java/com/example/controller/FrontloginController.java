package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.classes.FrontLoginClasses;
import com.example.service.FrontloginService;

@RestController
public class FrontloginController {
	
	@Autowired
	FrontloginService frontloginService;
	
	@PostMapping("/getauth")
	public void getauth(@RequestBody FrontLoginClasses loginInfo) {
		frontloginService.getauth(loginInfo);
		
	}
	
}
