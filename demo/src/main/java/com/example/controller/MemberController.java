package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Member;
import com.example.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService memberservice;
	
	@PostMapping("/getMemberInfo")
	public List<Member> getMemberInfo() {
		return memberservice.getMemberInfo();
	}

}
