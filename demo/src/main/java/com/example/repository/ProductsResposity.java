package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Products;

public interface ProductsResposity extends JpaRepository<Products, String>{
	List<Products> findByNameContaining(String name);
	List<Products> findByName(String name);
}
