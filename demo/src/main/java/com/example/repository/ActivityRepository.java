package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Activitys;

public interface ActivityRepository extends JpaRepository<Activitys, String> {
		List<Activitys> findByShopId(String shopId);
		Optional<Activitys> findByIdAndShopId(String id, String shopId);

		void deleteByIdAndShopId(String id, String shopId);

}
