package com.example.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.json.JSONArray;
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
			
			
			String fvJson=new String(si.getFrontStage(),"UTF-8");
			JSONArray ja=new JSONArray(fvJson);
			LinkedList<Map<String, Object>> bds=new LinkedList<Map<String, Object>>();
			for(Object bigDiv:ja) {
				JSONObject joDiv=new JSONObject((String)bigDiv);
				bds.add(joDiv.toMap());
			}
			
			System.out.println(fvJson);
			

			styleInfo.put("fullView", fvJson);
			styleInfo.put("nav", jo.toMap());
			
			return styleInfo;
			
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
		
		
		
		
	}
	
	public LinkedList<String> createBigDivHTML(Integer shopid) {
		HashMap<String, Object> style= getStyle(1);
		System.out.println(style);
		System.out.println("2");
//		LinkedList<BigDiv>fv= style.get("fullView");
		
		LinkedList<String> htmls=new LinkedList<String>();
		
//		for(BigDiv bd:fv) {
//			System.out.println(bd.getTemplateType());
//			System.out.println(bd.getWebElements());
//			
////			int type=Integer.parseInt(bd.getTemplateType().substring(3, 4));
//			
//			String html="";
////			for(int i=0;i<bd.getWebElements().size();i++) {
////				System.out.println("3");
////				System.out.println(bd.getWebElements().get(i).get("elementType"));
////				switch (bd.getWebElements().get(i).get("elementType").substring(0, 2)){
////				case "卡片": {
////					CardElementHTML card=new CardElementHTML(1,
////							bd.getWebElements().get(i).get("backRoundColor"),
////							bd.getWebElements().get(i).get("backRoundImg"),
////							bd.getWebElements().get(i).get("headerText1"),
////							bd.getWebElements().get(i).get("headerText2"),
////							bd.getWebElements().get(i).get("card-backround"),
////							bd.getWebElements().get(i).get("card-title-color"),
////							bd.getWebElements().get(i).get("card-text-color"),
////							jsonUtil.toLinkedList(bd.getWebElements().get(i).get("card-title")),
////							jsonUtil.toLinkedList(bd.getWebElements().get(i).get("cardImg")),
////							jsonUtil.toLinkedList(bd.getWebElements().get(i).get("card-text")));
////					html.concat(card.getCardElement());
////					break;
////					
////				}
////				default:
////					throw new IllegalArgumentException("Unexpected value: " +bd.getWebElements().get(i).get("elementType").substring(0, 2));
////				}
////				
////				
////				
////				System.out.println(html);
////				htmls.add(html);
////				
////				
////				
////		}
//			
//			
//		}
		
		
		return htmls;
	}

}
