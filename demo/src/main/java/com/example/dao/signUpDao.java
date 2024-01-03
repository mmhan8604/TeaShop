package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.shopInfo;

import jakarta.transaction.Transactional;

@Repository
public interface signUpDao extends JpaRepository<shopInfo, Integer>{

	List<shopInfo> findByAccount(String account);
	
	@Modifying
	@Transactional
	@Query(value = "insert into shop_info(account, password,name,phone,email) values(:account,:password,:name,:phone,:email)",nativeQuery = true)
	int create(@Param("account") String account, @Param("password") String password, @Param("name") String name, @Param("phone") String phone, @Param("email") String email);
}
