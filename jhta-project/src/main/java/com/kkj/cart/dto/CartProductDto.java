package com.kkj.cart.dto;

public class CartProductDto {
	int cartItemId;
	String pdtThum;
	int pdtId;
	int quantity;
	int cartId;
	String pickSize;
	String pdtName;
	int pdtPrice;

	public String getPdtName() {
		return pdtName;
	}

	public void setPdtName(String pdtName) {
		this.pdtName = pdtName;
	}

	public int getPdtPrice() {
		return pdtPrice;
	}

	public void setPdtPrice(int pdtPrice) {
		this.pdtPrice = pdtPrice;
	}

	public String getPdtThum() {
		return pdtThum;
	}

	public void setPdtThum(String pdtThum) {
		this.pdtThum = pdtThum;
	}

	public int getPdtId() {
		return pdtId;
	}

	public void setPdtId(int pdtId) {
		this.pdtId = pdtId;
	}

	public String getPickSize() {
		return pickSize;
	}

	public void setPickSize(String pickSize) {
		this.pickSize = pickSize;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public CartProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
