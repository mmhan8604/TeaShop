package com.example.controller;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.classes.logisticsUpdateDTO;
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
		HashMap<String, String> ldata= logis.getLogistics((String) session.getAttribute("email"));
		JSONObject ljson=new JSONObject(ldata);
		System.out.println(ldata.toString());
		return ljson.toString();
	}
	
	@PostMapping("/logisticsSet/update")
	public String logisticsUpdate(HttpServletRequest request,@RequestBody logisticsUpdateDTO lud) {
		HttpSession session=request.getSession();
//		(String) session.getAttribute("email")
		boolean check= logis.update((String) session.getAttribute("email"), lud);
		
		if(check) {
			return"ok";
		}else {
			return"error";
		}
		
	}

}
