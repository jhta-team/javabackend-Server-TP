package com.kkj.codyboard.dto;

public class PageNationDto {
	private int start;
	private int end;
	
	
	public PageNationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageNationDto(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
}
