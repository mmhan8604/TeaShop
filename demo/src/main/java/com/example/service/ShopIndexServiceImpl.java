package com.example.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.LinkedList;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.shopInfo;
import com.example.frontStage.BigDiv;
import com.example.interf.ShopIndexService;
import com.example.repository.frontStageDao;

@Service
public class ShopIndexServiceImpl implements ShopIndexService {
	
	@Autowired
	frontStageDao dao;
	@SuppressWarnings({ "unchecked"})
	@Override
	public HashMap<String, Object> getStyle(Integer shopid) {
		// TODO Auto-generated method stub
		
		
		try {
			
			shopInfo si=dao.findById(shopid).get();
			HashMap<String, Object> styleInfo = new HashMap<String, Object>();
			JSONObject jo= new JSONObject(si.getShopNav());
			
			if(si.getFrontStage()==null) {
				return null;
			}
			
			ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(si.getFrontStage()));
			styleInfo.put("fullView",(LinkedList<BigDiv>) ois.readObject());
			styleInfo.put("nav", jo.toMap());
			
			return styleInfo;
			
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}catch (ClassNotFoundException e) {
			
			return null;
		}catch (Exception e) {
			return null;
		}
		
		
		
		
		
	}
	
	public String createBigDivHTML(Integer shopid) {
		HashMap<String, Object> style= getStyle(shopid);
		
		return"";
	}

}
