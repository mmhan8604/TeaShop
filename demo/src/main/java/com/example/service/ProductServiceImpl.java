package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Products;
import com.example.repository.ProductsResposity;

import net.sf.jsqlparser.util.validation.ValidationException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductsResposity productsRes;

	@Override
	public Products addProduct(String id, Products products) {
		Optional<Products> optionalAddProduct = productsRes.findById(id);
		if (optionalAddProduct.isPresent()) {
			// 根據需求處理重複ID的情況，例如拋出異常
			throw new ValidationException("商品ID已存在");
		} else {
			// ID唯一，保存商品
			products.setId(id);
			return productsRes.save(products);
		}

	}

	@Override
	public Products delProduct(String productId) {
		Optional<Products> optionalProduct = productsRes.findById(productId);

		if (optionalProduct.isPresent()) {
			Products deletedProduct = optionalProduct.get();
			productsRes.deleteById(productId);
			return deletedProduct;
		} else {
			// 如果找不到該產品，您可以根據需求返回null或拋出異常等
			return null;
		}
	}

	@Override
	public Products save(Products products) {

		return productsRes.save(products);
	}

	@Override
	public Products updateProduct(String productId, Products products) {
		Optional<Products> opOriginProducts = productsRes.findById(productId);
		Products product = opOriginProducts.get();

		product.setId(products.getId());
		product.setName(products.getName());
		product.setStock(products.getStock());
		product.setShelves(products.getShelves());
		product.setPrice(products.getPrice());
		product.setCost(products.getCost());
		product.setDiscription(products.getDiscription());

		product.setPictext_0(products.getPictext_0());
		product.setPictext_1(products.getPictext_1());
		product.setPictext_2(products.getPictext_2());
		product.setPictext_3(products.getPictext_3());
		product.setPictext_4(products.getPictext_4());
		product.setPictext_5(products.getPictext_5());
		product.setPictext_6(products.getPictext_6());
		product.setPictext_7(products.getPictext_7());
		product.setPictext_8(products.getPictext_8());
		product.setPictext_9(products.getPictext_9());

		return save(product);
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
		return productsRes.findById(id);
	}

	@Override
	public Products updateDiscontinued(String productId, boolean discontinued) {
		Optional<Products> optionalProduct = productsRes.findById(productId);

		if (optionalProduct.isPresent()) {
			Products productToUpdate = optionalProduct.get();
			productToUpdate.setDiscontinued(discontinued);
			return productsRes.save(productToUpdate);
		}

		return null;
	}

}