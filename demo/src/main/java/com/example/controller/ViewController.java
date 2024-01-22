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
	
	
	
	@PostMapping("/clientReturn")		//付款後client端接綠界跳轉		//由表單直接跳轉post所以可以收到
	@CrossOrigin(originPatterns="*", allowCredentials="true", allowedHeaders = "*" )
	public String clientReturn(HttpSession session,@RequestBody String returnMsg,Model model) {
		String MSgJSON = EcpayReturnConverter.convertToJSON(returnMsg);
		System.out.println("clientReturn:"+MSgJSON);
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		if (loginInfo!=null) {
		model.addAttribute("jsonData", MSgJSON);
		model.addAttribute("shopId", loginInfo.getShopId());}
		else {
			model.addAttribute("jsonData", MSgJSON);
			model.addAttribute("shopId", 5);
		}

		return "/payresult";
	}
	
	@GetMapping("/backstage")				//後台畫面
	public String backstageView(HttpSession session) {
		
		return "/mainIndex";
	}
}
