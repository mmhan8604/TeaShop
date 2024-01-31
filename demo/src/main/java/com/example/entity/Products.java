package com.example.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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

	private String shopId;

	@Column(length = 60000, columnDefinition = "TEXT")
	private String pictext_0;

	public String getPictext_0() {
		return pictext_0;
	}

	public void setPictext_0(String pictext_0) {
		this.pictext_0 = pictext_0;
	}

	@Column(length = 60000, columnDefinition = "TEXT")
	private String pictext_1;

	public String getPictext_1() {
		return pictext_1;
	}

	public void setPictext_1(String pictext_1) {
		this.pictext_1 = pictext_1;
	}

	@Column(length = 60000, columnDefinition = "TEXT")
	private String pictext_2;

	public String getPictext_2() {
		return pictext_2;
	}

	public void setPictext_2(String pictext_2) {
		this.pictext_2 = pictext_2;
	}

	@Column(length = 60000, columnDefinition = "TEXT")
	private String pictext_3;

	public String getPictext_3() {
		return pictext_3;
	}

	public void setPictext_3(String pictext_3) {
		this.pictext_3 = pictext_3;
	}

	@Column(length = 60000, columnDefinition = "TEXT")
	private String pictext_4;

	public String getPictext_4() {
		return pictext_4;
	}

	public void setPictext_4(String pictext_4) {
		this.pictext_4 = pictext_4;
	}

	@Column(length = 60000, columnDefinition = "TEXT")
	private String picjson;

	public String getPicjson() {
		return picjson;
	}

	public void setPicjson(String picjson) {
		this.picjson = picjson;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

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