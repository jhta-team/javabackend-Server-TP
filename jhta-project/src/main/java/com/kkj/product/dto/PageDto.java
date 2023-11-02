package com.kkj.product.dto;

import java.util.List;

public class PageDto<T> {
    private List<T> data;      // 현재 페이지의 데이터
    private int currentPage;   // 현재 페이지 번호
    private int pageSize;      // 한 페이지에 표시될 항목 수
    private int totalItems;    // 전체 항목 수
    
    
	public PageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
    
    
    
}
