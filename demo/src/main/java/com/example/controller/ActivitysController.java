package com.example.controller;

import java.util.List;
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

import com.example.entity.Activitys;
import com.example.entity.Products;
import com.example.service.ActivityService;

@RestController
public class ActivitysController {
	@Autowired
	private ActivityService activityService;
	
	
//	ActivitysController(ActivityService activityService){
//		this.activityService = activityService;
//	}
	
	
	@PostMapping("/queryActivitys")
	public List<Activitys> queryActivitys(@RequestBody String shopId) {
		System.out.println("查詢全部"+ shopId);
		return activityService.queryActivitys(shopId);
	}

	
	@GetMapping("/queryActivitys/{id}") 
	public Optional<Activitys> read(@PathVariable int id){

	    return activityService.queryoneActivity(id);
	}
	
	@PostMapping("/addActivity")
	public String addActivity(@RequestBody Activitys activitys) {
		System.out.println("新增"+activitys.toString()); 
		activityService.addActivity(activitys);
		return activitys.toString();
	}
	
	@DeleteMapping("/delActivity/{id}")
    public String delActivity(@PathVariable int id) {    
        activityService.delActivity(id);
        return "ok";
    }
	
	@PutMapping("/updateActivity")
	public String updateActivity(@RequestBody Activitys activitys) {
		System.out.println("新增"+activitys.toString()); 
		activityService.updateActivity(activitys);
		return activitys.toString();
	}
}
