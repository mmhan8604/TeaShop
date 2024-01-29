package com.example.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Orders;
import java.util.List;


public interface OrdersRepository extends JpaRepository<Orders, String>{
	
	@Query("SELECT o FROM Orders o WHERE o.member.id = :memberId ORDER BY o.orderDate DESC")
    List<Orders> findOrdersByMemberIdOrderByOrderDateDesc(String memberId);

}
