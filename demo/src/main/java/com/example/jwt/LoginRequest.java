package com.example.jwt;

public class LoginRequest {
	private String userName;
    private String userId;
    
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "LoginRequest [userName=" + userName + ", userId=" + userId + "]";
	}
    
    
    
}
