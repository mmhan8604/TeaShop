package com.example.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.interf.frontStageService;

@RestController
public class testFrontControll {
	
	@Autowired
	private frontStageService fss;
	
	@PostMapping("/frontStageSet")
	private String frontStageSet(@RequestBody String data) {
		JSONObject jo=new JSONObject(data);
		
		fss.setattr(jo.get("url").toString());
		
		return"";
	}
	
	@GetMapping("/frontStageSet")
	private String frontStage() {
//		fss.getattr();
		return"llll";
	}

}
