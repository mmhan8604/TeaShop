package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.classes.FrontLoginClasses;
import com.example.entity.Member;
import com.example.service.MCFOservice;

import jakarta.servlet.http.HttpSession;

@RestController
public class MemberControllerForOrder {
	@Autowired
	MCFOservice memberservice;
	
	@PostMapping("/getMemberInfo")
	public Member getMemberInfo(@RequestBody String memberId) {
		return memberservice.getMemberInfo(memberId);
	}
	
	@PostMapping("/insertMember")
	public void insertMember(@RequestBody Member member,HttpSession session) {
		memberservice.insertMember(member);
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		loginInfo.setDisplayName(member.getName());
		session.setAttribute("authObject", loginInfo);
	}
}
