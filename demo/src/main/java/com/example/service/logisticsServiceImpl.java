package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	

}
