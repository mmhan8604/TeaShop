package com.example.frontStage;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;

public class BigDiv implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String templateType;
	
	private LinkedList<Map<String, String>> webElements;
	
	@SafeVarargs
	public BigDiv(Map<String, String>...webelements){
		webElements=new LinkedList<Map<String, String>>();
		for(Map<String, String> we:webelements) {
			this.webElements.add(we);
		}
//		style=webelements.length;
	}
	
	public BigDiv(LinkedList<Map<String, String>> webelements) {
		this.webElements=webelements;
//		style=webelements.size();
	}
	
	public BigDiv(String templateType,LinkedList<Map<String, String>> webElements) {
		this.templateType=templateType;
		this.webElements=webElements;
	}

	

	public LinkedList<Map<String, String>> getWebElements() {
		return webElements;
	}

	public void setWebElements(LinkedList<Map<String, String>> webElements) {
		this.webElements = webElements;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}
	

}
