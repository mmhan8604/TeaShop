package com.example.controller;

import java.util.ArrayList;
import java.util.List;

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
		
		System.out.println("新增"+products.toString()); 
		//System.out.println(products.getActivity().getID());
		productService.addProduct(products);
		return products.toString();
	}
	@PostMapping("/delProduct")
	public String delProduct(@RequestBody Products products) {
		
		System.out.println("刪除id"+products.getId()); 
		productService.delProduct(products);
		return products.toString();
	}
	@PostMapping("/editProduct")
	public String editProduct(@RequestBody Products products) {
		
		System.out.println("修改id"+products.getId()); 
		productService.editProduct(products);
		return products.toString();
	}
	@PostMapping("/queryProduct")
	public List<Products> queryProduct() {
		System.out.println("查詢全部");
		return productService.queryProduct();
	}
	@PostMapping("/queryProductByname")
	public List<Products> queryProductByName(@RequestBody String name) {
		System.out.println("查詢部分:"+name);
		return productService.queryProductByName(name);
	}
	
	@PostMapping("/queryProductById")
	public List<Products> queryProductById(@RequestBody String id) {
		System.out.println("查詢部分:"+id);
		List<Products> list= new ArrayList<>();
		list.add(productService.queryProductById(id));
		return list;
	}
}
