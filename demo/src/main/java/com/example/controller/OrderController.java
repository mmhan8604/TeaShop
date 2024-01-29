package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.classes.OrderItem;
import com.example.classes.OrderObject;
import com.example.entity.Member;
import com.example.entity.Orders;
import com.example.service.OrderService;
import com.example.utils.EcpayReturnConverter;
import com.example.utils.Tools;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;



@RestController
public class OrderController {
	Member member ;
	
	@Autowired
	OrderService orderService;

	@PostMapping("/ecpayCheckout")									//ecpay建立訂單
	public String ecpayCheckout(@RequestBody OrderObject OOB) {
		
		String aioCheckOutALLForm = orderService.ecpayCheckout(OOB);
		
		return aioCheckOutALLForm;
	}
	@PostMapping("/queryOrder")										//ecpay查詢訂單
	public String queryEcOrder(@RequestBody String orderId) {
		String PaymentInfo = orderService.queryEcOrder(orderId);
		String queryJSON = EcpayReturnConverter.convertToJSON(PaymentInfo);
		return queryJSON;
	}
																			
	@PostMapping("/serverReturn")								//付款後server端接收綠界回傳			//guess:因為現在不在全球網路上綠界方沒辦法連到localhost區網
	public String severReturn(@RequestBody String returnMsg) {
		System.out.println("\n\n\n\n test");
		System.out.println("serverReturn:"+returnMsg);
		
		return "1|OK";
	}
	
	//---------------------------------------------------------------------以上為ecpay
	
	@PostMapping("/getMember")								//1.加入訂單前取得member
	public void getMember(@RequestBody String memberId) {
			System.out.println("memberId"+memberId);
			member = orderService.getMember(memberId);
			System.out.println(member.getId());
			
	}
	
	@PostMapping("/postOrder")								//2.資料庫建立訂單
	public void postOreder(@RequestBody Orders order) {
		System.out.println(member.getId());
		order.setMember(member);
		orderService.postOrder(order);
		
	}
	
	@PostMapping("/orderdetail")							//3.加入訂單明細
	public void orderdetail(@RequestBody String data) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
            // 將JSON字串轉換為Map<String, OrderItem>
            Map<String, OrderItem> orderItemMap = objectMapper.readValue(data, new TypeReference<Map<String, OrderItem>>() {});

            // 遍歷Map，獲取每個訂單項目
            for (Map.Entry<String, OrderItem> entry : orderItemMap.entrySet()) {
                String key = entry.getKey();
                OrderItem orderItem = entry.getValue();
                orderService.postOrderDetail(orderItem);
                
                }
            	
            } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
	}
	
	@PostMapping("/findAllOrder")
	public List<Orders> findAllOrder (HttpSession session) {
		String shopid =Tools.intObjToString( session.getAttribute("backShopId"));
		
		return orderService.findAllOrder(shopid);
	}
	
	@PostMapping("/orderStateUpdate")
	public boolean orderStateUpdate (@RequestBody String OrderId) {
		
		return orderService.orderStateUpdate(OrderId);
	}
	
}