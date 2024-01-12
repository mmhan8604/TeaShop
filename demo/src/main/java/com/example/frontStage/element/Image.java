package com.example.frontStage.element;

import java.io.Serializable;
import java.util.HashMap;

import com.example.frontStage.Webelement;

public class Image extends Webelement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String url;
	String grid;
	String row;
	
	public Image(String url) {
		this.url= url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public HashMap<String, String> getAllAttr() {
		HashMap<String, String> data=new HashMap<String, String>();
		data.put("url", url);
		data.put("grid", grid);
		data.put("row", row);
		return data;
	}
}
