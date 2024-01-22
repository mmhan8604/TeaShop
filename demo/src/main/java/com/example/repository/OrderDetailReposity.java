package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Orderdetails;
import com.example.entity.Orderdetails.OrderdetailsId;


public interface OrderDetailReposity extends JpaRepository<Orderdetails, Orderdetails.OrderdetailsId> {
//亨+的查詢用
    List<Orderdetails> findByOrder_Id(String orderId);


}