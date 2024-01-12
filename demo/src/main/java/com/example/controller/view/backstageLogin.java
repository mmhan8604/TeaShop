package com.example.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class backstageLogin {
	
	@GetMapping("/login")
	public String login(Model model) {
		
		return"backstage/mainLogin";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		return"";
	}

}
