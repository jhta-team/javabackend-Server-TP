package com.kkj.member.dto;

public class MemberDateDto {
	private String userID;
	private String loginDate;
	private String deleteDate;
	private int datNo;
	private int count;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	public String getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	public int getDatNo() {
		return datNo;
	}
	public void setDatNo(int datNo) {
		this.datNo = datNo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
