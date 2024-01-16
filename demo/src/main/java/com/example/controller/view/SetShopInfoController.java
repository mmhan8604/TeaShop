package com.example.controller.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.classes.shopInfo;
import com.example.interf.SetShopInfoSerivice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class SetShopInfoController {
	
	@Autowired
	SetShopInfoSerivice ssis;
	
	@PostMapping("/setShopInfo")
	public String set(HttpServletRequest request, @RequestBody shopInfo data) {
		System.out.println(data.getLogo());
		
		HttpSession session=request.getSession();
//		data.setEmail((String) session.getAttribute("email"));
		data.setEmail("a@mail.com");
		ssis.setSi(data);
		int state= ssis.updateInfo();
		
		if(state==0) {
			return"ok";
		}else if (state==1) {
			return"!cover";
		}else {
			return"upload_fail";
		}
		
	}

}
