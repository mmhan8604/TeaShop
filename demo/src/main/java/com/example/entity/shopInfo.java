package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_info")
public class shopInfo {
	
	@Id
	private String id;
	
	
	@Column 
	private String name;

	@Column 
	private String phone;

	@Column 
	private String email; 
	
	@Column
	private String address;
	
	@Column 
	private String password;
	
	private String bankAccount;
	
	private String ShopLogoUrl;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getShopLogoUrl() {
		return ShopLogoUrl;
	}

	public void setShopLogoUrl(String shopLogoUrl) {
		ShopLogoUrl = shopLogoUrl;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	
	
}
