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
	private String id;
	
	private String name;
	
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ActivitysID")
	private Activitys activity;
	
	private int price;
	
	private int cost;

	private String discription;
	
	private int shelves;

	private int stock;
	
	private boolean discontinued;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Activitys getActivity() {
		return activity;
	}

	public void setActivity(Activitys activity) {
		this.activity = activity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getShelves() {
		return shelves;
	}

	public void setShelves(int shelves) {
		this.shelves = shelves;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", activity=" + activity + ", price=" + price + ", cost="
				+ cost + ", discription=" + discription + ", shelves=" + shelves + ", stock=" + stock
				+ ", discontinued=" + discontinued + "]";
	}
	
	
}
