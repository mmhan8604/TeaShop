package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.shopInfo;

@Repository
public interface loginDao extends JpaRepository<shopInfo, Integer>{
	
	
	
	List<shopInfo> findByAccount(String account);

}
