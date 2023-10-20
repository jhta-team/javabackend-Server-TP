package com.kkj.product.dto;

public class ImageDto {
	int imgId;
	String imgMain;
	String img1;
	String img2;
	String img3;
	int pdtId; 
	
	public int getPdtId() {
		return pdtId;
	}
	public void setPdtId(int pdtId) {
		this.pdtId = pdtId;
	}
	
	public int getImgId() {
		return imgId;
	}
	public void setImgId(int imgId) {
		this.imgId = imgId;
	}
	public String getImgMain() {
		return imgMain;
	}
	public void setImgMain(String imgMain) {
		this.imgMain = imgMain;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public ImageDto(int imgId, String imgMain, String img1, String img2, String img3, int pdtId) {
		super();
		this.imgId = imgId;
		this.imgMain = imgMain;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.pdtId = pdtId;
	}
	public ImageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ImageDto [imgId=" + imgId + ", imgMain=" + imgMain + ", img1=" + img1 + ", img2=" + img2 + ", img3="
				+ img3 + ", pdtId=" + pdtId + "]";
	}	
}
