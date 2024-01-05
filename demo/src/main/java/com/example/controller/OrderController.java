package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.OrderService;
import com.example.utils.EcpayReturnConverter;
import com.expamlpe.classes.OrderItem;
import com.expamlpe.classes.OrderObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PostMapping("/ecpayCheckout")									//建立訂單
	public String ecpayCheckout(@RequestBody OrderObject OOB) {
		System.out.println(OOB.getItemName());
		String aioCheckOutALLForm = orderService.ecpayCheckout(OOB);
		
		return aioCheckOutALLForm;
	}
	@PostMapping("/queryOrder")										//查詢訂單
	public String queryOrder(@RequestBody String orderId) {
		String PaymentInfo = orderService.queryOrder(orderId);
		String queryJSON = EcpayReturnConverter.convertToJSON(PaymentInfo);
		return queryJSON;
	}
																			
	@PostMapping("/serverReturn")								//付款後server端接收綠界回傳			//guess:因為現在不在全球網路上綠界方沒辦法連到localhost區網
	public String severReturn(@RequestBody String returnMsg) {
		System.out.println("\n\n\n\n test");
		System.out.println("serverReturn:"+returnMsg);
		
		return "1|OK";
	}
	
	
	@PostMapping("/orderdetail")
	public void orderdetail(@RequestBody String data) {
		System.out.println(data);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
            // 將JSON字串轉換為Map<String, OrderItem>
            Map<String, OrderItem> orderItemMap = objectMapper.readValue(data, new TypeReference<Map<String, OrderItem>>() {});

            // 遍歷Map，獲取每個訂單項目
            for (Map.Entry<String, OrderItem> entry : orderItemMap.entrySet()) {
                String key = entry.getKey();
                OrderItem orderItem = entry.getValue();
                orderService.postOrderDetail(orderItem);
                // 輸出每個訂單項目的信息
                System.out.println("Key: " + key);
                System.out.println("ProductId: " + orderItem.getProductId());
                System.out.println("Quantity: " + orderItem.getQuantity());
                System.out.println("Amount: " + orderItem.getAmount());
                System.out.println("OrderId: " + orderItem.getOrderId());
                System.out.println();}
            } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}