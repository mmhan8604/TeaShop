package com.example.controller;

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
import com.expamlpe.classes.OrderObject;



@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PostMapping("/ecpayCheckout")									//建立訂單
	public String ecpayCheckout(@RequestBody OrderObject OOB) {
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
//	@PostMapping("/clientReturn")									//付款後client端接綠界跳轉		//由表單直接跳轉post所以可以收到
//	public String clientReturn(@RequestBody String returnMsg,Model model) {
//		String MSgJSON = EcpayReturnConverter.convertToJSON(returnMsg);
//		System.out.println("clientReturn:"+MSgJSON);
//		model.addAttribute("jsonData", MSgJSON);
//
//		return "redirect:/payresult";
//	}
	
}