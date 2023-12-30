package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Member;
import com.example.repository.MemberRepository;

@Service
public class QueryUserService {
	@Autowired
	MemberRepository memberRes;
	public String findAll() {
		List<Member> list =memberRes.findAll();
		System.out.println(list.get(0).getName());
		return"";
	}
}
