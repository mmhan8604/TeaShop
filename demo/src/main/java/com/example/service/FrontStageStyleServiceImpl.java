package com.example.service;


import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.shopInfo;

import com.example.interf.FrontStageStyleService;
import com.example.repository.frontStageDao;

@Service
public class FrontStageStyleServiceImpl implements FrontStageStyleService {
	@Autowired
	private frontStageDao dao;
	
	public int updateStyle(String email,String nav,String fullView) {
		shopInfo si= dao.findByEmail(email).get(0);
		
		byte[] fvArray;
		try {
			fvArray = fullView.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return 2;
		}
		
		si.setFrontStage(fvArray);
		si.setShopNav(nav);
		
		try {
			dao.save(si);
		} catch (Exception e) {
			return 1;
		}
			
			
			
			
		return 0;
	}
	
	
}
