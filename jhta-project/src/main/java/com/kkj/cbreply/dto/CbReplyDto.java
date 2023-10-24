package com.kkj.cbreply.dto;

public class CbReplyDto {
	private int no;
	private String replyUserID;
	private String reply;
	private String regDate;
	private int codyBoardNo;
	private int cbCommentNo;
	
	
	
	public CbReplyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CbReplyDto(int no, String replyUserID, String reply, String regDate, int codyBoardNo, int cbCommentNo) {
		super();
		this.no = no;
		this.replyUserID = replyUserID;
		this.reply = reply;
		this.regDate = regDate;
		this.codyBoardNo = codyBoardNo;
		this.cbCommentNo = cbCommentNo;
	}


	@Override
	public String toString() {
		return "CbReplyDto [no=" + no + ", replyUserID=" + replyUserID + ", reply=" + reply + ", regDate=" + regDate
				+ ", codyBoardNo=" + codyBoardNo + ", cbCommentNo=" + cbCommentNo + "]";
	}


	public String getReplyUserID() {
		return replyUserID;
	}
	public void setReplyUserID(String replyUserID) {
		this.replyUserID = replyUserID;
	}
	public int getCbCommentNo() {
		return cbCommentNo;
	}
	public void setCbCommentNo(int cbCommentNo) {
		this.cbCommentNo = cbCommentNo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
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
