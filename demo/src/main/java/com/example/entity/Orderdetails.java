package com.example.entity;

import java.io.Serializable;
import java.util.Objects;

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
    
	private int amount;
	
	private int price;
	
	private int quantity;

	
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
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public static class OrderdetailsId implements Serializable {
	    private Orders order;
	    private Products product;
	    public OrderdetailsId() {
	    	
	    }
	    
	    public OrderdetailsId(Orders order, Products product) {
	        this.order = order;
	        this.product = product;
	    }
	    
	}

}
