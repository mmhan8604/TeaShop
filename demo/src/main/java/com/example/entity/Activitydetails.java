package com.example.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "activitydetails")
@IdClass(Activitydetails.ActivityDetailsId.class)
public class Activitydetails implements Serializable {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProductsID")
    private Products products;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ActivitysID")
    private Activitys activitys;

    private double discount;
	
    
	public Products getProducts() {
		return products;
	}


	public void setProducts(Products products) {
		this.products = products;
	}


	public Activitys getActivitys() {
		return activitys;
	}


	public void setActivitys(Activitys activitys) {
		this.activitys = activitys;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public Activitydetails() {
		// TODO Auto-generated constructor stub
	}

	
	public static class ActivityDetailsId implements Serializable {
	    private String products;
	    private String activitys;
	    }
	
}
