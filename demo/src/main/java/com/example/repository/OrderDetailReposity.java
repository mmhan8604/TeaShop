package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Orderdetails;

public interface OrderDetailReposity extends JpaRepository<Orderdetails, String>{

}
