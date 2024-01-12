package com.example.frontStage;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class fullView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<BigDiv> all;
	
	public fullView(BigDiv...bigDivs) {
		all=new LinkedList<BigDiv>();
		for(BigDiv bd:bigDivs) {
			all.add(bd);
		}
	}
	
	public fullView(LinkedList<BigDiv> all) {
		this.all=all;
	}

	public LinkedList<BigDiv> getAll() {
		return all;
	}

	public void setAll(LinkedList<BigDiv> all) {
		this.all = all;
	}

}
