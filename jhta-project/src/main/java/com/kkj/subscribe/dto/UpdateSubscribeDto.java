package com.kkj.subscribe.dto;

public class UpdateSubscribeDto {
	private String userID;
	private String subscribeEnd;
	
	
	public UpdateSubscribeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UpdateSubscribeDto(String userID, String subscribeEnd) {
		super();
		this.userID = userID;
		this.subscribeEnd = subscribeEnd;
	}
	
	@Override
	public String toString() {
		return "UpdateSubscribeDto [userID=" + userID + ", subscribeEnd=" + subscribeEnd + "]";
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getSubscribeEnd() {
		return subscribeEnd;
	}
	public void setSubscribeEnd(String subscribeEnd) {
		this.subscribeEnd = subscribeEnd;
	}
}
