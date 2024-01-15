package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.MailService;

@RestController
public class Mailcontroller {
	
	@Autowired
	MailService mailservice;
	
	@PostMapping("/sendmail")
	public String sendmail(@RequestBody Map<String, String> data) {
	    String shopId = data.get("shopId");
	    String content = data.get("content");
	    String title = data.get("title");
	    System.out.println(shopId + content);
	    mailservice.sendPlainText("waspat1109@yahoo.com", "<Project:客戶回饋>"+title, content);
	    return "送出";
	}
}
