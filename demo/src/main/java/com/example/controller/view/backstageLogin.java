package com.example.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class backstageLogin {
	
	@GetMapping("/login")
	public String login(Model model) {
		
		return"backstage/mainLogin.html";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		return"backstage/mainRegist";
	}
	
	@GetMapping("/logout")
	public String logout(Model model,HttpSession session) {
		session.removeAttribute("email");
		session.removeAttribute("backShopId");
		return"backstage/mainLogin.html";
	}

}
