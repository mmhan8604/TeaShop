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
	public void addProduct(Products products) {
		if (productsRes.existsById(products.getId())) {
			throw new ValidationException("id重複");
		} else {
			productsRes.save(products);
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
		// TODO Auto-generated method stub
		return productsRes.findById(id);
	}

}