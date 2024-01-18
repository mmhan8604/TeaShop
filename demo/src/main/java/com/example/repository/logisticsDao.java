package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.shopInfo;

@Repository
public interface logisticsDao extends JpaRepository<shopInfo, Integer>{
	
	List<shopInfo> findByEmail(String email);
}
