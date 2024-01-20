package com.example.classes;

public class FrontLoginClasses {
	
	private String displayName;
	private String email;
	private Boolean emailVerified;
	private String providerId;
	private String loginMethod;
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getEmailVerified() {
		return emailVerified;
	}
	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}
	
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getLoginMethod() {
		return loginMethod;
	}
	public void setLoginMethod(String loginMethod) {
		this.loginMethod = loginMethod;
	}
	@Override
	public String toString() {
		return "FrontLoginClasses [displayName=" + displayName + ", email=" + email + ", emailVerified=" + emailVerified
				+ ", providerId=" + providerId + ", loginMethod=" + loginMethod + "]";
	}
	
	
	
}