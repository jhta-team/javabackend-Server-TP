package com.kkj.subscribe.dto;

public class SubscribeDto {
	private int no;
	private String month;
	private int price;
	
	public SubscribeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubscribeDto(int no, String month, int price) {
		super();
		this.no = no;
		this.month = month;
		this.price = price;
	}
	@Override
	public String toString() {
		return "SubscribeDto [no=" + no + ", month=" + month + ", price=" + price + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
