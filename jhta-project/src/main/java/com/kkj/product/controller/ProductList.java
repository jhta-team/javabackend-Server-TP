package com.kkj.product.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.kkj.member.dto.MemberDto;
import com.kkj.product.dao.ProductDao;
import com.kkj.product.dto.PageDto;
import com.kkj.product.dto.ProductDto;
import com.kkj.product.page.Pagination;

public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao pdtDao = new ProductDao();
		
		HashMap<String, Integer> map = new HashMap<>();
		
		String strPage = request.getParameter("page");
		int totalCount = pdtDao.countProduct();
		int intpage =0;
		int lastpage = 10;
		int totalpage =(int)Math.ceil(totalCount/(double)lastpage);
		if(strPage==null || strPage.isEmpty()) {
			intpage =1;			
		}else {
			intpage =  Integer.parseInt(strPage);
		}
		if(totalpage < intpage) {
			intpage = totalpage;
		}
		int startpage = ((intpage-1)/lastpage)*lastpage+1;
		int endpage = startpage + lastpage -1;
		if(endpage > totalpage) {
			endpage =totalpage;
		}
		map.put("start", (intpage-1)*9 +1);
		map.put("end", intpage*9);
		System.out.println(map.values());
		List<ProductDto> listDto = new ArrayList<ProductDto>();
		listDto = pdtDao.listProduct(map);
		
		request.setAttribute("ProductList", listDto);
		request.setAttribute("intpage", intpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("totalCount", totalCount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/productlist.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
