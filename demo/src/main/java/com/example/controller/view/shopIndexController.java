package com.example.controller.view;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.interf.ShopIndexService;

@Controller
public class shopIndexController {
	
	ShopIndexService sis;
	
	@GetMapping("/shopPage/{shopid}")
	public String index(Model model,@PathVariable Integer shopid) {
		HashMap<String, Object> styleInfo=sis.getStyle(shopid);
		model.addAttribute("nav", styleInfo.get("nav"));
		model.addAttribute("fullView", styleInfo.get("fullView"));
		return"shopPage/customize.html";
	}
}
