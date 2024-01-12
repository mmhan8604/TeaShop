package com.example.frontStage;

import java.io.Serializable;
import java.util.LinkedList;

public class BigDiv implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int style;
	
	private LinkedList<Webelement> webElements;
	
	public BigDiv(Webelement...webelements){
		webElements=new LinkedList<Webelement>();
		for(Webelement we:webelements) {
			this.webElements.add(we);
		}
		style=webelements.length;
	}
	
	public BigDiv(LinkedList<Webelement> webelements) {
		this.webElements=webelements;
		style=webelements.size();
	}

	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}

	public LinkedList<Webelement> getWebElements() {
		return webElements;
	}

	public void setWebElements(LinkedList<Webelement> webElements) {
		this.webElements = webElements;
	}
	

}
