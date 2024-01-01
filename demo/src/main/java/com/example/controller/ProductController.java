package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Products;
import com.example.service.ProductService;
import com.expamlpe.classes.ProductObj;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping("/addProduct")
	public String AddProduct(@RequestBody Products products) {
		
		System.out.println(products.getID()); 
		//System.out.println(products.getActivity().getID());
		productService.AddProduct(products);
		return "";
	}
	
}
