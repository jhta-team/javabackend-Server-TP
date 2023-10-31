package com.kkj.subscribe.dto;

public class SubscribePaymentDto {
	private int no;
	private String userID;
	private int price;
	private String imp_uid;
	private String product;
	private String status;
	private String regDate;
	
	
	public SubscribePaymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubscribePaymentDto(int no, String userID, int price, String imp_uid, String product, String status,
			String regDate) {
		super();
		this.no = no;
		this.userID = userID;
		this.price = price;
		this.imp_uid = imp_uid;
		this.product = product;
		this.status = status;
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "SubscribePaymentDto [no=" + no + ", userID=" + userID + ", price=" + price + ", imp_uid=" + imp_uid
				+ ", product=" + product + ", status=" + status + ", regDate=" + regDate + "]";
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImp_uid() {
		return imp_uid;
	}
	public void setImp_uid(String imp_uid) {
		this.imp_uid = imp_uid;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	







	
}
