package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.classes.logisticsUpdateDTO;
import com.example.entity.shopInfo;
import com.example.interf.logisticsService;
import com.example.repository.logisticsDao;

@Service
public class logisticsServiceImpl implements logisticsService {
	@Autowired
	logisticsDao dao;
	
	@Override
	public HashMap<String, String> getLogistics(String email) {
		
		List<shopInfo> siList= dao.findByEmail(email);
		shopInfo siEntity=siList.get(0);
		 
		HashMap<String, String> data= new HashMap<String, String>();
		data.put("isp_cod", siEntity.getIsp_cod()==null?"":siEntity.getIsp_cod());
		data.put("isp_rfi", siEntity.getIsp_refri()==null?"":siEntity.getIsp_cod());
		data.put("del_cod", siEntity.getDeli_cod()==null?"":siEntity.getIsp_cod());
		data.put("del_rfi", siEntity.getDeli_refri()==null?"":siEntity.getIsp_cod());
		return data;
	}
	
	public boolean update(String email,logisticsUpdateDTO lud) {
		List<shopInfo> siList= dao.findByEmail(email);
		shopInfo siEntity=siList.get(0);
		siEntity.setDeli_cod(lud.getDel_cod());
		siEntity.setDeli_refri(lud.getDel_ref());
		siEntity.setIsp_cod(lud.getIsp_cod());
		siEntity.setIsp_refri(lud.getIsp_ref());
		
		try {
			dao.save(siEntity);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	

}
