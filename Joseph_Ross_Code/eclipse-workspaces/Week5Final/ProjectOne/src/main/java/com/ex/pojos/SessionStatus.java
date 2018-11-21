package com.ex.pojos;

public class SessionStatus {
	
	private Boolean sessionExists;
	private String forwardUrl;
	
	public Boolean getSessionExists() {
		return sessionExists;
	}
	public void setSessionExists(Boolean sessionExists) {
		this.sessionExists = sessionExists;
	}
	public String getForwardUrl() {
		return forwardUrl;
	}
	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}
}
