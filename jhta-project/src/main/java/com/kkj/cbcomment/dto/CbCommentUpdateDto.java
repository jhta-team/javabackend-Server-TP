package com.kkj.cbcomment.dto;

public class CbCommentUpdateDto {
	private int no;
	private String cbCommentUpdate;
	
	public CbCommentUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CbCommentUpdateDto(int no, String cbCommentUpdate) {
		super();
		this.no = no;
		this.cbCommentUpdate = cbCommentUpdate;
	}
	
	@Override
	public String toString() {
		return "CbCommentUpdateDto [no=" + no + ", cbCommentUpdate=" + cbCommentUpdate + "]";
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCbCommentUpdate() {
		return cbCommentUpdate;
	}
	public void setCbCommentUpdate(String cbCommentUpdate) {
		this.cbCommentUpdate = cbCommentUpdate;
	}

}
