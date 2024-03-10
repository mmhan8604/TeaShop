package com.example.controller.view;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.interf.ShopIndexService;

@Controller
public class shopIndexController {
	@Autowired
	ShopIndexService sis;
	
	@GetMapping("/shopPage/{shopid}")
	public String index(Model model,@PathVariable Integer shopid) {
		HashMap<String, Object> styleInfo=sis.getStyle(shopid);
		System.out.println("1");
		HashMap<String, List> data=sis.createBigDivHTML(shopid);
		model.addAttribute("fullView",(List<List<String>>) data.get("htmls"));
		model.addAttribute("shopId",shopid);
		
		model.addAttribute("nav", styleInfo.get("nav"));
//		model.addAttribute("fullView", styleInfo.get("fullView"));
		model.addAllAttributes(data);
		return"shopPage/customize.html";
	}
}
