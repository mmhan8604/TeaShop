package com.example.controller;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.interf.logisticsService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class logisticsController {
	@Autowired
	logisticsService logis;
	
	@GetMapping("/logisticsSet/Table")
	public String logisticsTable(HttpServletRequest request) {
		HttpSession session=request.getSession();
//		data.setEmail((String) session.getAttribute("email"));
		//(String) session.getAttribute("email")
		HashMap<String, String> ldata= logis.getLogistics("a@mail.com");
		JSONObject ljson=new JSONObject(ldata);
		System.out.println(ldata.toString());
		return ljson.toString();
	}

}
