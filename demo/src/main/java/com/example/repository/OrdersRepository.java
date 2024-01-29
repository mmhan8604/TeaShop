package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, String>{
	List<Orders> findByShopIdOrderByOrderDateAsc(String shopId);
}
