package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Member;
import com.example.service.QueryUserService;

@RestController
public class QueryUserController {
	@Autowired
	QueryUserService QUS;
	
	@PostMapping("/queryUser")
	public String queryMembers(){
		QUS.findAll();
		return "";
	}
}
