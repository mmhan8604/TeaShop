package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Orderdetails;
import com.example.entity.Orderdetails.OrderdetailsId;

public interface OrderDetailReposity extends JpaRepository<Orderdetails, OrderdetailsId>{

}
