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
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductsResposity productsRes;

	@Override
	public void addProduct(Products products) {
		if (productsRes.existsById(products.getId())) {
			throw new ValidationException("id重複");
		} else {
			productsRes.save(products);
		}

	}

	@Override
	public void delProduct(Products products) {
		if (productsRes.existsById(products.getId())) {
			productsRes.delete(products);
		} else {
			throw new ValidationException("id不存在，無法刪除");
		}

	}

	@Override
	public void editProduct(Products products) {
		Optional<Products> opOriginProducts = productsRes.findById(products.getId());
		Products originProducts = opOriginProducts.get();
		if (productsRes.existsById(products.getId())) {
			Activitys activity = originProducts.getActivity();
			products.setActivity(activity);
			productsRes.save(products);
		} else {
			throw new ValidationException("id不存在，無法查詢");
		}

	}

	@Override
	public List<Products> queryProduct(String shopId) {
		return productsRes.findByShopIdOrderByNameAsc(shopId);
	}

	@Override
	public List<Products> queryProductByName(String name) {
		return productsRes.findByNameContaining(name);
	}

	@Override
	public Products queryProductById(String id) {
		return productsRes.findById(id).orElseThrow(() -> new ValidationException("id不存在"));
	}

	@Override
	public Optional<Products> findById(String id) {
		// TODO Auto-generated method stub
		return productsRes.findById(id);
	}

}