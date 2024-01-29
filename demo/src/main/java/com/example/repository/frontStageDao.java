package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.shopInfo;

public interface frontStageDao extends JpaRepository<shopInfo, Integer>{
	List<shopInfo> findByEmail(String account);
}
