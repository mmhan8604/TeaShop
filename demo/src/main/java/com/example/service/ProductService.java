package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Activitys;
import com.example.entity.Products;
import com.example.repository.ProductsResposity;

import net.sf.jsqlparser.util.validation.ValidationException;

@Service
public class ProductService {
	@Autowired
	ProductsResposity productsRes;
	//增
	public void addProduct(Products products) {	
		
		if (productsRes.existsById(products.getId())) {
				throw new ValidationException("id重複");
			
		}
		else {productsRes.save(products);}
	}
	//刪
	public void delProduct(Products products) {
		productsRes.delete(products);
	}
	//修
	public void editProduct(Products products) {
		Optional<Products> opOriginProducts = productsRes.findById(products.getId());
		Products originProducts = opOriginProducts.get();
		if (productsRes.existsById(products.getId())) {
			Activitys activity = originProducts.getActivity();
			products.setActivity(activity);
			productsRes.save(products);
		} else {
			throw new ValidationException("id不存在");
		}
		
		
	}
	public List<Products> queryProduct() {
		return productsRes.findAll();
		
	}
	public List<Products> queryProduct(String name){
		return productsRes.findByName(name);
	}
}
