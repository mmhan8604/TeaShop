package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entity.Member;
import com.example.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
    private MemberRepository memberRepository;

    // 獲取所有會員資訊
    public List<Member> getAllMemberInfo() {
        return memberRepository.findAll();
    }
    
    // 獲取特定會員資訊
    public Member getMemberInfo(String memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }
    
    // 計算特定會員的總消費金額
    public Integer getTotalSpentByMember(String memberId) {
        return memberRepository.calculateTotalSpentByMemberId(memberId);
    }
    
    public List<Object[]> getAllMembersWithTotalSpent() {
        return memberRepository.findAllMembersWithTotalSpent();
    }

}
