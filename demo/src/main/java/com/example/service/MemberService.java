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
	MemberRepository memberRes;

	public List<Member> getMemberInfo() {
		return memberRes.findAll();
	}

}
