package com.kkj.cart.dto;

public class CartDto {
	int cartId;
	String userId;
	String cartName;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCartName() {
		return cartName;
	}
	public void setCartName(String cartName) {
		this.cartName = cartName;
	}
	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
