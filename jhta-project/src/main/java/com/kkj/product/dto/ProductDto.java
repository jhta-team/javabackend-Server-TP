package com.kkj.product.dto;

public class ProductDto {
	int pdtId;
	String pdtName;
	String pdtCty;
	String pdtContent;
	int pdtPrice;
	int pdtCount;
	int pdtState;
	String pdtDate;
	String pdtModDate;
	String pdtThum;
	String pdtColor;
	
	
	public int getPdtId() {
		return pdtId;
	}
	public void setPdtId(int pdtId) {
		this.pdtId = pdtId;
	}
	public String getPdtName() {
		return pdtName;
	}
	public void setPdtName(String pdtName) {
		this.pdtName = pdtName;
	}
	public String getPdtCty() {
		return pdtCty;
	}
	public void setPdtCty(String pdtCty) {
		this.pdtCty = pdtCty;
	}
	public String getPdtContent() {
		return pdtContent;
	}
	public void setPdtContent(String pdtContent) {
		this.pdtContent = pdtContent;
	}
	public int getPdtPrice() {
		return pdtPrice;
	}
	public void setPdtPrice(int pdtPrice) {
		this.pdtPrice = pdtPrice;
	}
	public int getPdtCount() {
		return pdtCount;
	}
	public void setPdtCount(int pdtCount) {
		this.pdtCount = pdtCount;
	}
	public int getPdtState() {
		return pdtState;
	}
	public void setPdtState(int pdtState) {
		this.pdtState = pdtState;
	}
	public String getPdtDate() {
		return pdtDate;
	}
	public void setPdtDate(String pdtDate) {
		this.pdtDate = pdtDate;
	}
	public String getPdtModDate() {
		return pdtModDate;
	}
	public void setPdtModDate(String pdtModDate) {
		this.pdtModDate = pdtModDate;
	}
	public String getPdtThum() {
		return pdtThum;
	}
	public void setPdtThum(String pdtThum) {
		this.pdtThum = pdtThum;
	}
	public String getPdtColor() {
		return pdtColor;
	}
	public void setPdtColor(String pdtColor) {
		this.pdtColor = pdtColor;
	}	
	public ProductDto() {
		super();
	}
	@Override
	public String toString() {
		return "ProductDto [pdtId=" + pdtId + ", pdtName=" + pdtName + ", pdtCty=" + pdtCty + ", pdtContent="
				+ pdtContent + ", pdtPrice=" + pdtPrice + ", pdtCount=" + pdtCount + ", pdtState=" + pdtState
				+ ", pdtDate=" + pdtDate + ", pdtModDate=" + pdtModDate + ", pdtThum=" + pdtThum + ", pdtColor="
				+ pdtColor + "]";
	}		
}
