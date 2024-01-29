package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Products;

@Service
public interface ProductService {
	Products addProduct(String id,Products products);
    Products delProduct(String id);
    
    List<Products> queryProduct(String shopId);
    List<Products> queryProductByName(String name);
    Products queryProductById(String id);
    Optional<Products> findById(String id);
    
    Products save(Products products);
    Products updateProduct(String productId,Products products);
    
    Products updateDiscontinued(String productId, boolean discontinued);
}
