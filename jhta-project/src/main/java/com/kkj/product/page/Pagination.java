package com.kkj.product.page;

import java.util.List;

import com.kkj.product.dto.PageDto;

public class Pagination {
	private int listSize = 12;                //초기값으로 목록개수를 10으로 셋팅
	private int rangeSize = 10;            //초기값으로 페이지범위를 10으로 셋팅
	private int page;
	private int range;
	private int listCnt;
	private int pageCnt;
	private int startPage;
	private int startList;
	private int endPage;
	private boolean prev;
	private boolean next;

	
}
