package com.kkj.cbreply.dto;

public class CbReplyUpdateDto {
	private int no;
	private String replyUpdate;
	
	public CbReplyUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CbReplyUpdateDto(int no, String replyUpdate) {
		super();
		this.no = no;
		this.replyUpdate = replyUpdate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getReplyUpdate() {
		return replyUpdate;
	}
	public void setReplyUpdate(String replyUpdate) {
		this.replyUpdate = replyUpdate;
	}
	

}
