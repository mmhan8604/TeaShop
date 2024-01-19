package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Activitys;

public interface ActivityRepository extends JpaRepository<Activitys, Integer> {
		List<Activitys> findByShopId(String shopId);
}
