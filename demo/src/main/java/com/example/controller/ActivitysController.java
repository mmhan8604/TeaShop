package com.example.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Activitydetails;
import com.example.entity.Activitys;
import com.example.entity.Products;
import com.example.service.ActivityService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ActivitysController {
	@Autowired
	private ActivityService activityService;


	// 查全部
	@PostMapping("/queryActivitys")
	public List<Activitys> queryActivitys(@RequestBody String shopId) {
		System.out.println("查詢全部" + shopId);
		return activityService.queryActivitys(shopId);
	}


	//增
	@PostMapping("/addActivity")
	public ResponseEntity<String> saveActivityWithDetails(@RequestBody Map<String, Map<String, Object>> requestData) {
		Map<String, Object> activityData = requestData.get("activitys");
		Map<String, Object> activityDetailsData = requestData.get("activitydetails");

		Activitys activitys = convertMapToActivity(activityData);
		Activitydetails activitydetails = convertMapToActivityDetails(activityDetailsData);

		activityService.saveActivityWithDetails(activitys, activitydetails);

		return ResponseEntity.ok("Data saved successfully");
	}

	private Activitys convertMapToActivity(Map<String, Object> activityData) {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(activityData, Activitys.class);
	}

	private Activitydetails convertMapToActivityDetails(Map<String, Object> activityDetailsData) {
		ObjectMapper objectMapper2 = new ObjectMapper();
		return objectMapper2.convertValue(activityDetailsData, Activitydetails.class);
	}


	// 刪
	@PostMapping("/delActivity/{id}")
    public String delActivity(@PathVariable String id, @RequestBody String shopId) {    
        
        return "ok";
    }


	// 查一筆
	@PostMapping("/queryActivitys/{id}") 
	public Optional<Activitys> queryoneActivity(@PathVariable String id, @RequestBody String shopId ){
	
	    return activityService.queryoneActivity(id, shopId);
	}
	
	// 修
	//@PostMapping("/updateActivity")
//	public String updateActivity(@RequestBody Activitys activitys) {
//		System.out.println("編輯" + activitys.toString());
//		activityService.updateActivity(activitys);
//		return activitys.toString();
//	}

}