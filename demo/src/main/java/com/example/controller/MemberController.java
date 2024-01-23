package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.entity.Member;
import com.example.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
    private MemberService memberService;
    
//    @PostMapping("/getAllMemberInfo")
//    public List<Member> getMemberInfo() {
//        return memberService.getAllMemberInfo();
//    }
//    
//    @PostMapping("/members/{memberId}/totalSpent")
//    public Integer getTotalSpentByMember(@PathVariable String memberId) {
//        return memberService.getTotalSpentByMember(memberId);
//    }
//    
    @PostMapping("/getAllMemberInfoWithTotalSpent")
    public List<Object[]> getAllMembersWithTotalSpent() {
        return memberService.getAllMembersWithTotalSpent();
    }
}
