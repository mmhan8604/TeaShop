package com.example.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderItem {

	 private String productId;
	    private String quantity;
	    private String price;
	    private String amount;
	    private String orderId;

	    // 省略構造方法和其他getter/setter

	    @JsonProperty("productId")
	    public String getProductId() {
	        return productId;
	    }

	    @JsonProperty("quantity")
	    public String getQuantity() {
	        return quantity;
	    }

	    @JsonProperty("amount")
	    public String getAmount() {
	        return amount;
	    }

	    @JsonProperty("orderId")
	    public String getOrderId() {
	        return orderId;
	    }
	    
	    @JsonProperty("price")
	    public String getPrice() {
	        return price;
	    }
	}