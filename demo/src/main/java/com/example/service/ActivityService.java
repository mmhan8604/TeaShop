package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Activitydetails;
import com.example.entity.Activitys;
import com.example.repository.ActivityDetailsRepository;
import com.example.repository.ActivityRepository;

import jakarta.transaction.Transactional;
import net.sf.jsqlparser.util.validation.ValidationException;

@Service
public class ActivityService {
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private ActivityDetailsRepository activityDetailsRepository;
	
	
	//查全部
	public List<Activitys> queryActivitys(String shopId) {
		return activityRepository.findByShopId(shopId);	
	}

	
	//增
	@Transactional
    public void saveActivityWithDetails(Activitys activitys, Activitydetails activitydetails) {
        Activitys savedActivitys = activityRepository.save(activitys);
        activitydetails.setActivitys(savedActivitys);
        activityDetailsRepository.save(activitydetails);
    }
	
	
	//刪
	@Transactional
    public void delActivity(String id, String shopId) {
       
		//activityDetailsRepository.deleteByProductsIdAndActivitysId( productsId ,id);
        activityRepository.deleteByIdAndShopId(id, shopId);
    }
	
	//查一筆
	public Optional<Activitys> queryoneActivity(String id, String shopId){
		
		return activityRepository.findByIdAndShopId(id, shopId);
	}
	
	
	//修
//	public void updateActivity(Activitys activitys) {	
//		activityRepository.save(activitys);
//	}

	
}
