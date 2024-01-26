package com.example.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.shopInfo;
import com.example.frontStage.BigDiv;
import com.example.frontStage.element.CardElementHTML;
import com.example.interf.ShopIndexService;
import com.example.repository.frontStageDao;
import com.example.utils.jsonUtil;

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
		
		LinkedList<BigDiv>fv= (LinkedList<BigDiv>) style.get("fullView");
		String html="";
		
		for(BigDiv bd:fv) {
			int type=Integer.parseInt(bd.getTemplateType().substring(3, 4));
			
			switch (bd.getTemplateType().substring(0, 2)) {
			case "卡片": {
				for(int i=0;i<bd.getWebElements().size();i++) {
					if(type<6) {
						CardElementHTML card=new CardElementHTML(type,
								bd.getWebElements().get(i).get("backRoundColor"),
								bd.getWebElements().get(i).get("backRoundImg"),
								bd.getWebElements().get(i).get("headerText1"),
								bd.getWebElements().get(i).get("headerText2"),
								bd.getWebElements().get(i).get("card-backround"),
								bd.getWebElements().get(i).get("card-title-color"),
								bd.getWebElements().get(i).get("card-text-color"),
								jsonUtil.toLinkedList(bd.getWebElements().get(i).get("card-title")),
								jsonUtil.toLinkedList(bd.getWebElements().get(i).get("cardImg")),
								jsonUtil.toLinkedList(bd.getWebElements().get(i).get("card-text")));
						}
						
				}
				
				break;
				
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + bd.getTemplateType());
			}
		}
		
		return"";
	}

}
