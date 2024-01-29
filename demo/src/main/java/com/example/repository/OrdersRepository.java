package com.example.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, String>{
	List<Orders> findByShopIdOrderByOrderDateAsc(String shopId);
	
	@Query("SELECT o FROM Orders o WHERE o.member.id = :memberId ORDER BY o.orderDate DESC")
    List<Orders> findOrdersByMemberIdOrderByOrderDateDesc(String memberId);
	
	List<Orders> findByOrderDateBetweenAndShopId(LocalDateTime startDateTime, LocalDateTime endDateTime,String shopId);
}