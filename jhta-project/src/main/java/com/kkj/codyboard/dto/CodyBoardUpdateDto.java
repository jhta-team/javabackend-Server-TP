package com.kkj.codyboard.dto;

public class CodyBoardUpdateDto {
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	private int no;
	public CodyBoardUpdateDto(int no, String title, String content, int categoryID, String images) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.categoryID = categoryID;
		this.images = images;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	private String title;
	private String content;
	private int categoryID;
	private String images;
	
	public CodyBoardUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

}
