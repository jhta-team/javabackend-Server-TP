package com.kkj.codyboard.dto;

public class CodyBoardDto {
	private int no;
	private String title;
	private String content;
	private String images;
	private int hit;
	private String regDate; 
	private int categoryID;
	
	public CodyBoardDto(int no, String title, String content, String images, int hit, String regDate, int categoryID) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.images = images;
		this.hit = hit;
		this.regDate = regDate;
		this.categoryID = categoryID;
	}
	
	@Override
	public String toString() {
		return "CodyDto [no=" + no + ", title=" + title + ", content=" + content + ", images=" + images + ", hit="
				+ hit + ", regDate=" + regDate + ", categoryID=" + categoryID + "]";
	}
	
	public CodyBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
}