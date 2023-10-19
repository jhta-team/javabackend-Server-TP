package com.kkj.product.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kkj.product.dao.ProductDao;
import com.kkj.product.dto.ProductDto;

public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ProductDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDao detailDao = new ProductDao();
		ProductDto detailDto = new ProductDto();
		detailDto = detailDao.detailProduct(id);
		request.setAttribute("detailDto", detailDto);
		//System.out.println(detailDto.toString());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/productdetail.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
