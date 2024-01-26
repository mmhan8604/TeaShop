package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.classes.FrontLoginClasses;
import com.example.entity.Member;
import com.example.repository.MemberRepository;

import jakarta.servlet.http.HttpSession;
import net.sf.jsqlparser.util.validation.ValidationException;

@Service
public class MCFOservice {
	@Autowired
	MemberRepository memberRes;
	
	public Member getMemberInfo(String memberId) {
		return memberRes.findById(memberId).get();
	}
	
	public Member insertMember(Member member) {
		String newId = createMemberId();
		member.setId(newId);
		memberRes.save(member);
		return member;
	}
	public void editMember(Member member) {
		if(memberRes.existsById(member.getId())) {
			memberRes.save(member);
		}else {
			throw new ValidationException("無此id");
		}
	}
	
	
	
	
	private String createMemberId() {
		String newId = "M" + String.format("%04d", memberRes.count());
		return newId;
	}
}
