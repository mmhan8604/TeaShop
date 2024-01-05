package com.example.frontStage.element;

import com.example.frontStage.BigDiv;
import com.example.frontStage.fullView;

public class test {
	
	
	
	

	public static void main(String[] args) {
		 Image a= new Image("aaa");
		 BigDiv bd=new BigDiv(a);
		 fullView fv=new fullView(bd);
		 
		
		System.out.println(fv.getAll().get(0).getWebElements().get(0));		
		

	}

}
