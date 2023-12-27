package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.utils.EcpayReturnConverter;

@Controller
public class Thtleafcontroller {
	@GetMapping(value = "/model")
	// 將Model 作為Controller 的引數，由Spring 框架自動創建並作為參數傳入
	public String model(Model model) {
		// 設定傳遞資料
	  model.addAttribute("message", "Hello thymeleaf. (using Model)");

		// 返回值指定頁面路徑
	  return "model";
	}
	@PostMapping("/clientReturn")									//付款後client端接綠界跳轉		//由表單直接跳轉post所以可以收到
	public String clientReturn(@RequestBody String returnMsg,Model model) {
		String MSgJSON = EcpayReturnConverter.convertToJSON(returnMsg);
		System.out.println("clientReturn:"+MSgJSON);
		model.addAttribute("jsonData", MSgJSON);

		return "/payresult";
	}
}
