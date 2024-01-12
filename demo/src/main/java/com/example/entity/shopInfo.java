package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_info")
public class shopInfo {
	
	@Id
	private Integer id;
	
	@Column 
	private String account;
	
	@Column 
	private String password;

	@Column 
	private String name;

	@Column 
	private String phone;

	@Column 
	private String email;
	
	@Column
	private String bankAccount;
	
	@Column
	private String ShopLogoUrl;
	
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

	@Column(columnDefinition = "BLOB")
	@Lob
	private byte[] frontStage;

	public byte[] getFrontStage() {
		return frontStage;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFrontStage(byte[] bs) {
		this.frontStage = bs;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public Integer getId() {
		return id;
	}

	
	
}
