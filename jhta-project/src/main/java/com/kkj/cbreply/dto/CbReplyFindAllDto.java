package com.kkj.cbreply.dto;

public class CbReplyFindAllDto {
	private int codyBoardNo;
	private int cbCommentNo;
	
	
	public CbReplyFindAllDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CbReplyFindAllDto(int codyBoardNo, int cbCommentNo) {
		super();
		this.codyBoardNo = codyBoardNo;
		this.cbCommentNo = cbCommentNo;
	}
	@Override
	public String toString() {
		return "CbReplyFindAllDto [codyBoardNo=" + codyBoardNo + ", cbCommentNo=" + cbCommentNo + "]";
	}
	public int getCodyBoardNo() {
		return codyBoardNo;
	}
	public void setCodyBoardNo(int codyBoardNo) {
		this.codyBoardNo = codyBoardNo;
	}
	public int getCbCommentNo() {
		return cbCommentNo;
	}
	public void setCbCommentNo(int cbCommentNo) {
		this.cbCommentNo = cbCommentNo;
	}
	
	
}
