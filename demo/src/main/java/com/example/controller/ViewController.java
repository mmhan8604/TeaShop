package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.classes.FrontLoginClasses;
import com.example.utils.EcpayReturnConverter;

import jakarta.servlet.http.HttpSession;

@Controller
public class ViewController {
	
	
	
	
	
	@GetMapping("/backstage")				//後台畫面
	public String backstageView(HttpSession session) {
		
		return "/mainIndex";
	}
}
