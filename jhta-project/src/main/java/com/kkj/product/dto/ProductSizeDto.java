package com.kkj.product.dto;

public class ProductSizeDto {

	int pdtSizeId;
	int pdtId;
	int pdtCount;
	int pdtSizes[] = new int[4];
	int pdtCounts[] = new int[4];

	public int[] getPdtCounts() {
		return pdtCounts;
	}

	public void setPdtCounts(int[] pdtCounts) {
		this.pdtCounts = pdtCounts;
	}

	public int[] getPdtSizes() {
		return pdtSizes;
	}

	public void setPdtSizes(int[] pdtSizes) {
		this.pdtSizes = pdtSizes;
	}

	int pdtCountS;
	int pdtCountM;
	int pdtCountL;
	int pdtCountXL;

	public int getPdtCount() {
		return pdtCount;
	}

	public void setPdtCount(int pdtCount) {
		this.pdtCount = pdtCount;
	}

	public int getPdtSizeId() {
		return pdtSizeId;
	}

	public void setPdtSizeId(int pdtSizeId) {
		this.pdtSizeId = pdtSizeId;
	}

	public int getPdtId() {
		return pdtId;
	}

	public void setPdtId(int pdtId) {
		this.pdtId = pdtId;
	}

	public int getPdtCountS() {
		return pdtCountS;
	}

	public void setPdtCountS(int pdtCountS) {
		this.pdtCountS = pdtCountS;
	}

	public int getPdtCountM() {
		return pdtCountM;
	}

	public void setPdtCountM(int pdtCountM) {
		this.pdtCountM = pdtCountM;
	}

	public int getPdtCountL() {
		return pdtCountL;
	}

	public void setPdtCountL(int pdtCountL) {
		this.pdtCountL = pdtCountL;
	}

	public int getPdtCountXL() {
		return pdtCountXL;
	}

	public void setPdtCountXL(int pdtCountXL) {
		this.pdtCountXL = pdtCountXL;
	}

	public ProductSizeDto() {
		super();
	}

}
