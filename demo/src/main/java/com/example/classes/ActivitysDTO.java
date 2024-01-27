package com.example.classes;


import java.util.List;

import com.example.entity.Activitydetails;
import com.example.entity.Activitys;
import com.example.entity.Products;



public class ActivitysDTO {
	
	private Activitys activitys;
    private List<Activitydetails> activitydetailsList;
    private List<Products> products;


    public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public Activitys getActivitys() {
        return activitys;
    }

    public void setActivitys(Activitys activitys) {
        this.activitys = activitys;
    }

    public List<Activitydetails> getActivitydetailsList() {
        return activitydetailsList;
    }

    public void setActivitydetailsList(List<Activitydetails> activitydetailsList) {
        this.activitydetailsList = activitydetailsList;
    }


}

	    

		


