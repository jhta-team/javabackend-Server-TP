package com.kkj.follow.dto;

public class FollowDto {
	private String followID;
	private String myID;
	
	
	public FollowDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FollowDto(String followID, String myID) {
		super();
		this.followID = followID;
		this.myID = myID;
	}
	@Override
	public String toString() {
		return "FollowDto [followID=" + followID + ", myID=" + myID + "]";
	}
	public String getFollowID() {
		return followID;
	}
	public void setFollowID(String followID) {
		this.followID = followID;
	}
	public String getMyID() {
		return myID;
	}
	public void setMyID(String myID) {
		this.myID = myID;
	}

}
