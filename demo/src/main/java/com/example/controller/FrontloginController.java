package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.classes.FrontLoginClasses;
import com.example.service.FrontloginService;

import jakarta.servlet.http.HttpSession;
import net.sf.jsqlparser.util.validation.ValidationException;

@RestController
public class FrontloginController {
	
	@Autowired
	FrontloginService frontloginService;
	
	@PostMapping("/getauth")
	public int getauth(HttpSession session,@RequestBody FrontLoginClasses loginInfo) {
		int state = frontloginService.getauth(loginInfo);
		System.out.println(loginInfo);
		if(state==1) {
			session.setAttribute("authObject", loginInfo);
			FrontLoginClasses FC= (FrontLoginClasses)session.getAttribute("authObject");
			
			return 1;
		}else if(state == 2) {
			return 2;
		}
		else {
			throw new ValidationException("登入資訊錯誤");
		}
		
	}
	@PostMapping("/shop/logout")
	public void logout(HttpSession session) {
		session.setAttribute("authObject", null);
	}
	
}
