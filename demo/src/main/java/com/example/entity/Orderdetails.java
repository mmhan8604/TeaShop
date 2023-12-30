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
@Table(name = "orderdetails")
@IdClass(Orderdetails.OrderdetailsId.class)
public class Orderdetails {
	@Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OrdersID")
    private Orders order;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProductsID")
    private Products product;
    
	private int Amount;
	
	private int Price;
	
	private int Quantity;

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public class OrderdetailsId implements Serializable {
	    private String order;
	    private String product;
		
	    // constructors, getters, setters, equals, and hashCode methods
	}

}
