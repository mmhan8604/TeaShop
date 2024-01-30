package com.example.controller;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.BackStageChartService;
import com.example.utils.Tools;

import jakarta.servlet.http.HttpSession;

@RestController
public class BackStageChartController {
	@Autowired
	BackStageChartService chartService;
	
	@PostMapping("/dayRevenue")
	public Map<String, Integer> dayRevenue(@RequestBody String today,HttpSession session) {
		String shopid =Tools.intObjToString( session.getAttribute("backShopId")); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		LocalDateTime dateTime = LocalDateTime.parse(today, formatter);
		int todayRevenue = chartService.getTodayRevenue(dateTime,shopid);	//日營收
		int monthRevenue = chartService.getMonthRevenue(dateTime,shopid);	//月營收
		int ordersQuantity = chartService.getOrderSum(shopid);				//訂單數
		int	membersQuantity = chartService.getMemberSum(shopid);			//會員數
		Map<String, Integer> revenueMap = new HashMap<>();
        revenueMap.put("todayRevenue", todayRevenue);
        revenueMap.put("monthRevenue", monthRevenue);
        revenueMap.put("ordersQuantity", ordersQuantity);
        revenueMap.put("membersQuantity", membersQuantity);
		return revenueMap;
	}
	
	@PostMapping("/bestsell")
	public List<Object[]> bestSellProduct(HttpSession session){
		String shopid =Tools.intObjToString( session.getAttribute("backShopId")); 
		return chartService.bestSellProduct(shopid);
	}
	
	@PostMapping("/lastFewMonthRevenue")
	public Map<String, Integer> lastFewMonthRevenue(@RequestBody String today,HttpSession session) {
		String shopid =Tools.intObjToString( session.getAttribute("backShopId")); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		LocalDateTime dateTime = LocalDateTime.parse(today, formatter);
		Map<String, Integer> revenueMap = new LinkedHashMap<>();
		for(int i=0;i<=6;i++) {
			revenueMap.put(Integer.toString(dateTime.minusMonths(i).getMonthValue())+"/"+Integer.toString(dateTime.minusMonths(i).getYear())
			, chartService.getMonthRevenue(dateTime.minusMonths(i),shopid));
		}
		
		return revenueMap;
		}
}
