package com.example.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.shopInfo;
import com.example.frontStage.BigDiv;
import com.example.interf.FrontStageStyleService;
import com.example.repository.frontStageDao;

@Service
public class FrontStageStyleServiceImpl implements FrontStageStyleService {
	@Autowired
	private frontStageDao dao;
	
	public int updateStyle(String email,String nav,LinkedList<BigDiv> fullView) {
		shopInfo si= dao.findByEmail(email).get(0);
		
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		try {
			ObjectOutputStream oops=new ObjectOutputStream(baos);
			oops.writeObject(fullView);
			oops.flush();
			byte[] style=baos.toByteArray();
			oops.close();
			si.setFrontStage(style);
			
			si.setShopNav(nav);
			
			dao.save(si);
			
		} catch (IOException e) {
			return 1;
			
		}catch (Exception e) {
			return 2;
		}
		return 0;
	}
	
	
}
