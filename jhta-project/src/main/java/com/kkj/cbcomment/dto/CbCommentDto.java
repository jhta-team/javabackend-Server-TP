package com.kkj.cbcomment.dto;

public class CbCommentDto {
	private int no;
	private String userID;
	private String cbComment;
	private String regDate;
	private int codyBoardNo;
	
	public CbCommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CbCommentDto(int no, String userID, String cbComment, String regDate, int codyBoardNo) {
		super();
		this.no = no;
		this.userID = userID;
		this.cbComment = cbComment;
		this.regDate = regDate;
		this.codyBoardNo = codyBoardNo;
	}
	
	@Override
	public String toString() {
		return "CbCommentDto [no=" + no + ", userID=" + userID + ", cbComment=" + cbComment + ", regDate=" + regDate
				+ ", codyBoardNo=" + codyBoardNo + "]";
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getComment() {
		return cbComment;
	}
	public void setComment(String cbComment) {
		this.cbComment = cbComment;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getCodyBoardNo() {
		return codyBoardNo;
	}
	public void setCodyBoardNo(int codyBoardNo) {
		this.codyBoardNo = codyBoardNo;
	}
	
}
