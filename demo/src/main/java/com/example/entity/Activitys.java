package com.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Activitys {
	@Id
	private String ID;
	private String Name;
	private LocalDateTime StartDate;
	private LocalDateTime EndDate;
	private String Discription;
	private String Method;
	private int FreeShipping;
	
	public Activitys() {
		// TODO Auto-generated constructor stub
	}

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

	public LocalDateTime getStartDate() {
		return StartDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		StartDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return EndDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		EndDate = endDate;
	}

	public String getDiscription() {
		return Discription;
	}

	public void setDiscription(String discription) {
		Discription = discription;
	}

	public String getMethod() {
		return Method;
	}

	public void setMethod(String method) {
		Method = method;
	}

	public int getFreeShipping() {
		return FreeShipping;
	}

	public void setFreeShipping(int freeShipping) {
		FreeShipping = freeShipping;
	}
	
}
