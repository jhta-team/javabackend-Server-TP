package com.kkj.cblike.dto;

public class CbLikeDto {
	private int no;
	private int cbNo;
	private String userID;
	
	public CbLikeDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public CbLikeDto(int no, int cbNo, String userID) {
		super();
		this.no = no;
		this.cbNo = cbNo;
		this.userID = userID;
	}




	@Override
	public String toString() {
		return "CbLikeDto [no=" + no + ", cbNo=" + cbNo + ", userID=" + userID + "]";
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

	public int getCbNo() {
		return cbNo;
	}
	public void setCbNo(int cbNo) {
		this.cbNo = cbNo;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
}
