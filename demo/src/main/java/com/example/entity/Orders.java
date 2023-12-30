package com.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {
	@Id
	private String ID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MemberID")
	private Member member;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProductsID")
	private Products product;
	
	private String OrderState;
	
	private String EcPayReturn;
	
	private String PaymentMethod;
	
	private int Amount;

	private String ShipMethod;
	
	private String ShipState;
	
	private LocalDateTime ShipDate;
	
	private String 	ReceiverName;

	private String 	ReceiverPhone;
	
	private String 	ReceiverMail;

	private String 	ReceiverCity;
	
	private String 	ReceiverAddress;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public String getOrderState() {
		return OrderState;
	}

	public void setOrderState(String orderState) {
		OrderState = orderState;
	}

	public String getEcPayReturn() {
		return EcPayReturn;
	}

	public void setEcPayReturn(String ecPayReturn) {
		EcPayReturn = ecPayReturn;
	}

	public String getPaymentMethod() {
		return PaymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public String getShipMethod() {
		return ShipMethod;
	}

	public void setShipMethod(String shipMethod) {
		ShipMethod = shipMethod;
	}

	public String getShipState() {
		return ShipState;
	}

	public void setShipState(String shipState) {
		ShipState = shipState;
	}

	public LocalDateTime getShipDate() {
		return ShipDate;
	}

	public void setShipDate(LocalDateTime shipDate) {
		ShipDate = shipDate;
	}

	public String getReceiverName() {
		return ReceiverName;
	}

	public void setReceiverName(String receiverName) {
		ReceiverName = receiverName;
	}

	public String getReceiverPhone() {
		return ReceiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		ReceiverPhone = receiverPhone;
	}

	public String getReceiverMail() {
		return ReceiverMail;
	}

	public void setReceiverMail(String receiverMail) {
		ReceiverMail = receiverMail;
	}

	public String getReceiverCity() {
		return ReceiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		ReceiverCity = receiverCity;
	}

	public String getReceiverAddress() {
		return ReceiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		ReceiverAddress = receiverAddress;
	}


}
