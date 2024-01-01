package com.example.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Products {
	@Id
	private String ID;
	
	private String Name;
	
	
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ActivitysID")
//	private Activitys activity;
	
	private int Price;
	
	private int Cost;

	private String Discription;
	
	private int Shelves;

	private int Stock;
	
	private boolean Discontinued;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

//	public Activitys getActivity() {
//		return activity;
//	}
//
//	public void setActivity(Activitys activity) {
//		this.activity = activity;
//	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	

	public int getCost() {
		return Cost;
	}

	public void setCost(int cost) {
		Cost = cost;
	}

	public String getDiscription() {
		return Discription;
	}

	public void setDiscription(String discription) {
		Discription = discription;
	}

	public int getShelves() {
		return Shelves;
	}

	public void setShelves(int shelves) {
		Shelves = shelves;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public boolean isDiscontinued() {
		return Discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		Discontinued = discontinued;
	}
	
}
