package com.example.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
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

import com.example.classes.ActivitysDTO;
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

	// 增
	@PostMapping("/addActivity")
	public String addActivityWithDetails(@RequestBody ActivitysDTO activitysDTO) {
		Activitys activitys = activitysDTO.getActivitys();
		List<Activitydetails> activitydetailsList = activitysDTO.getActivitydetailsList();

		return activityService.addActivityWithDetails(activitys, activitydetailsList);
	}

	// 刪
	@PostMapping("/delActivity/{activityId}")
	public ResponseEntity<String> deleteActivitys(@PathVariable String activityId) {
		try {
			activityService.deleteActivitys(activityId);
			return new ResponseEntity<>("Activity and related Activitydetails deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error deleting activity and activitydetails1",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// 查一筆
	@GetMapping("/queryActivitys/{id}")
	public ResponseEntity<ActivitysDTO> getActivityWithDetails(@PathVariable String id) {
		try {
			ActivitysDTO activitysDTO = activityService.getActivityWithDetails(id);
			return new ResponseEntity<>(activitysDTO, HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// 修
	@PostMapping("/updateActivity/{id}")
	public String updateActivityWithDetails(@PathVariable String id, @RequestBody ActivitysDTO activitysDTO) {
		Activitys activitys = activitysDTO.getActivitys();
		List<Activitydetails> activitydetailsList = activitysDTO.getActivitydetailsList();

		return activityService.updateActivityWithDetails(activitys, activitydetailsList);
	}
	
	//撈產品
	@PostMapping("/findProducts")
	public List<Products> findProducts(@RequestBody String shopId) {
		
		return activityService.queryProducts(shopId);
	}


}