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
		member =memberservice.insertMember(member);
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		loginInfo.setDisplayName(member.getName());
		loginInfo.setMemberId(member.getId());
		session.setAttribute("authObject", loginInfo);
	}
	
	@PostMapping("/editMember")
	public void editMember(@RequestBody Member member,HttpSession session) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		loginInfo.setDisplayName(member.getName());
		memberservice.editMember(member);
		
	}
}
