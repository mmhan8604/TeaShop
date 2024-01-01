package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Products;
import com.example.repository.ProductsResposity;

@Service
public class ProductService {
	@Autowired
	ProductsResposity productsRes;
	public void AddProduct(Products products) {
		products.setID("123");
		productsRes.save(products);
		
		
	}
}
