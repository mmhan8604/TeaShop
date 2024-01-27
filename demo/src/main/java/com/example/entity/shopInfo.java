package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_info")
public class shopInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@Column 
	private String shopName;

	
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
	
	@Column(length = 60000 ,columnDefinition = "TEXT")
	private String shopLogoUrl;
	
	private String shopCoverURL;
	
	private String shopIntro;
	
	private String isp_cod;
	private String isp_refri;
	private String deli_cod;
	private String deli_refri;
	
	



	@Column(columnDefinition = "BLOB")
	@Lob
	private byte[] frontStage;



	



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getShopName() {
		return shopName;
	}



	public void setShopName(String shopName) {
		this.shopName = shopName;
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



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getBankAccount() {
		return bankAccount;
	}



	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}



	public String getShopLogoUrl() {
		return shopLogoUrl;
	}



	public void setShopLogoUrl(String shopLogoUrl) {
		this.shopLogoUrl = shopLogoUrl;
	}



	public byte[] getFrontStage() {
		return frontStage;
	}



	public void setFrontStage(byte[] frontStage) {
		this.frontStage = frontStage;
	}



	public String getShopCoverURL() {
		return shopCoverURL;
	}



	public void setShopCoverURL(String shopCoverURL) {
		this.shopCoverURL = shopCoverURL;
	}



	public String getShopIntro() {
		return shopIntro;
	}



	public void setShopIntro(String shopIntro) {
		this.shopIntro = shopIntro;
	}
	
	public String getIsp_cod() {
		return isp_cod;
	}



	public void setIsp_cod(String isp_cod) {
		this.isp_cod = isp_cod;
	}



	public String getIsp_refri() {
		return isp_refri;
	}



	public void setIsp_refri(String isp_refri) {
		this.isp_refri = isp_refri;
	}



	public String getDeli_cod() {
		return deli_cod;
	}



	public void setDeli_cod(String deli_cod) {
		this.deli_cod = deli_cod;
	}



	public String getDeli_refri() {
		return deli_refri;
	}



	public void setDeli_refri(String deli_refri) {
		this.deli_refri = deli_refri;
	}
	



	

	

	
	
	
	
}
