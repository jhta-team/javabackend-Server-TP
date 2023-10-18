package com.kkj.codyboard.dto;

public class CodyBoardDto {
	private int no;
	private String title;
	private String content;
	private String images;
	private int view;
	private String regDate; 
	private int categoryID;
	
	public CodyBoardDto(int no, String title, String content, String images, int view, String regDate, int categoryID) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.images = images;
		this.view = view;
		this.regDate = regDate;
		this.categoryID = categoryID;
	}
	
	@Override
	public String toString() {
		return "CodyDto [no=" + no + ", title=" + title + ", content=" + content + ", images=" + images + ", view="
				+ view + ", regDate=" + regDate + ", categoryID=" + categoryID + "]";
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
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
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