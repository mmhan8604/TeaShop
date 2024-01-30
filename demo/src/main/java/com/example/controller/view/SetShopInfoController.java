package com.example.controller.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		
		HttpSession session=request.getSession();
		if(data.getEmail().equals("")){
			data.setEmail((String) session.getAttribute("email"));
		}
//		data.setEmail((String) session.getAttribute("email"));
//		data.setEmail("a@mail.com");
//		ssis.setSi(data);
		String email=(String) session.getAttribute("email");
		int state= ssis.updateInfo(data,email);
		
		if(state==0) {
			if( session.getAttribute("email").equals(data.getEmail())||(data.getEmail().equals(""))) {
				
			}else {
				session.setAttribute("email", data.getEmail());
			}
			return"ok";
		}else if (state==1) {
			return"!cover";
		}else {
			return"upload_fail";
		}
		
	}
	
	

}
