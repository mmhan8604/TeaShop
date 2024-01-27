package com.example.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.shopInfo;
import com.example.frontStage.BigDiv;
import com.example.frontStage.element.CardElementHTML;
import com.example.frontStage.element.CarouselElementHTML;
import com.example.frontStage.element.FormElementHTML;
import com.example.frontStage.element.ImgElementHTML;
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
//				JSONObject joDiv=(JSONObject) bigDiv;
//				bds.add(joDiv.toMap());
				
				JSONObject bdJson= (JSONObject)bigDiv;
				bds.add(bdJson.toMap());
				
			}
			
			

			styleInfo.put("fullView", bds);
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
	
	public HashMap<String, List> createBigDivHTML(Integer shopid) {
		HashMap<String, Object> style= getStyle(1);
//		System.out.println(style);
		System.out.println("2");
		LinkedList<Map<String, Object>> fv= (LinkedList<Map<String, Object>>) style.get("fullView");
		
		
		LinkedList<List<String>> htmls=new LinkedList<List<String>>();
		LinkedList<String> templateTypes=new LinkedList<String>();
		
		for(Map<String, Object> bd:fv) {
			
			List<Object> webElements= (List<Object>)(bd.get("webelements"));
//			List<Object> webElements=.toList();
			 templateTypes.add(bd.get("templateType").toString());
			
			String html="";
			LinkedList<String> welw=new LinkedList<String>();
			for(int i=0;i<webElements.size();i++) {
				Map<String, Object> webElement=((Map<String, Object>) (webElements.get(i)));
				
				
				
				switch (webElement.get("elementType").toString().substring(0, 2)){
				case "卡片": {
					int type=Integer.parseInt(webElement.get("elementType").toString().substring(3, 4));
					CardElementHTML card=new CardElementHTML(type,
							 webElement.get("backRoundColor").toString(),
							 webElement.get("backRoundImg").toString(),
							 webElement.get("headerText1").toString(),
							 webElement.get("headerText2").toString(),
							 jsonUtil.objtoLinkedList(webElement.get("card-backround")).get(i).toString(),
							 jsonUtil.objtoLinkedList(webElement.get("card-title-color")).get(i).toString(),
							 jsonUtil.objtoLinkedList(webElement.get("card-text-color")).get(i).toString(),
							 jsonUtil.objtoLinkedList(webElement.get("card-title")),
							 jsonUtil.objtoLinkedList(webElement.get("cardImg")),
							 jsonUtil.objtoLinkedList(webElement.get("card-text")));
					
//					html= html.concat();
					welw.add(card.getCardElement());
					htmls.add(welw);
					break;
					
				} case"輪播":{
					
					CarouselElementHTML carousel=new CarouselElementHTML(jsonUtil.objtoLinkedList(webElement.get("carouselImg")));
					welw.add(carousel.getCarouselElement());
					
					htmls.add(welw);
					break;
				} case"表單":{
					int type=Integer.parseInt(webElement.get("elementType").toString().substring(5));
					
					FormElementHTML form=new FormElementHTML(type,
							webElement.get("headerText1").toString(),
							 webElement.get("headerText2").toString(),
							 webElement.get("childBackroundColor").toString(), 
							 webElement.get("childBackroundImg").toString(), 
							 webElement.get("formImg").toString());
					welw.add(form.getFormElement());
					htmls.add(welw);
					break;
					
				} case"圖片":{
					int type=Integer.parseInt(webElement.get("elementType").toString().substring(3, 4));
					
					ImgElementHTML img=new ImgElementHTML(type,webElement.get("headerText1").toString(),
							webElement.get("headerText2").toString(),
							jsonUtil.objtoLinkedList(webElement.get("img")));
					welw.add(img.getImgElement());
					htmls.add(welw);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " +webElement.get("elementType").toString().substring(0, 2));
				}
				
				
				
				
				
			}
			
			
		}
		
		HashMap<String, List> data=new HashMap<String, List>();
		data.put("htmls", htmls);
		data.put("templateTypes", templateTypes);
		
		return data;
	}

}
