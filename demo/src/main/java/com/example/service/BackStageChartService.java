package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Orders;
import com.example.entity.Products;
import com.example.repository.MemberRepository;
import com.example.repository.OrderDetailReposity;
import com.example.repository.OrdersRepository;
import com.example.repository.ProductsResposity;

import io.jsonwebtoken.lang.Arrays;

@Service
public class BackStageChartService {
	
	@Autowired 
	OrdersRepository orderRes;
	@Autowired 
	MemberRepository memberRes;
	
	@Autowired
	ProductsResposity productsRes;
	
	public int getTodayRevenue(LocalDateTime today,String shopId){
		LocalDateTime startOfDay = today.withHour(0).withMinute(0).withSecond(0);
        LocalDateTime endOfDay = today.withHour(23).withMinute(59).withSecond(59);
        List<Orders> orders = orderRes.findByOrderDateBetweenAndShopId(startOfDay, endOfDay,shopId);
        AtomicInteger todaySum = new AtomicInteger(0);
        orders.forEach(order -> todaySum.addAndGet(order.getAmount()));
        System.out.println(todaySum.get());
        return todaySum.get();
		
	}
	
	public int getMonthRevenue(LocalDateTime today,String shopId){
		LocalDateTime startOfMonth = today.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
		LocalDateTime endOfMonth = today.withDayOfMonth(today.getMonth().maxLength()).withHour(23).withMinute(59).withSecond(59);
        List<Orders> orders = orderRes.findByOrderDateBetweenAndShopId(startOfMonth, endOfMonth,shopId);
        AtomicInteger monthSum = new AtomicInteger(0);
        orders.forEach(order -> monthSum.addAndGet(order.getAmount()));
        System.out.println(monthSum.get());
        return monthSum.get();
		
	}
	
	public int getOrderSum(String shopId) {
		return orderRes.findByShopIdOrderByOrderDateAsc(shopId).size();
	}
	public int getMemberSum(String shopId) {
		return memberRes.findByShopId(shopId).size();
	}
	
	public List<Object[]> bestSellProduct(String ShopId){
		List<Object[]> result = productsRes.findBestSellingProductsByShopId(ShopId);
		for (Object[] row : result) {
		    System.out.println("Row: " + java.util.Arrays.toString(row));    
		}
		return productsRes.findBestSellingProductsByShopId(ShopId);
	}
	
	
}
