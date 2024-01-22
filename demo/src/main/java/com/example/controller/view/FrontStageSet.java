package com.example.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontStageSet {
	
	@GetMapping("/FrontStageSet")
	public String styleSet(Model model) {
		
		return"backstage/main_v3.html";
		
	}
}
