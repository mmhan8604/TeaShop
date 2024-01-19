package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Activitys;
import com.example.repository.ActivityRepository;

import net.sf.jsqlparser.util.validation.ValidationException;

@Service
public class ActivityService {
	@Autowired
	private ActivityRepository activityRepository;
	
	
//	public ActivityService(ActivityRepository activityRepository) {
//		this.activityRepository = activityRepository;
//	}
//	
	//查全部
	public List<Activitys> queryActivitys(String shopId) {
		return activityRepository.findByShopId(shopId);	
	}
	//查一筆
	public Optional<Activitys> queryoneActivity(int id){
		return activityRepository.findById(id);
	}
	//增
	public void addActivity(Activitys activitys) {	
		activityRepository.save(activitys);
//		if (activityRepository.existsById(activitys.getId())) {
//				throw new ValidationException("id重複");
//			
//		}
//		else {activityRepository.save(activitys);}
	}
	
	//刪
	public void delActivity(int id) {	
		
		activityRepository.deleteById(id);
	}
	
	//修
	public void updateActivity(Activitys activitys) {	
		activityRepository.save(activitys);
	}

	
}
