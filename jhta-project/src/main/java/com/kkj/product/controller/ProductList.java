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
import java.util.List;

import com.kkj.product.dao.ProductDao;
import com.kkj.product.dto.ProductDto;

public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao pdtDao = new ProductDao();
		List<ProductDto> listDto = new ArrayList<ProductDto>();
		listDto = pdtDao.listProduct();
		request.setAttribute("ProductList", listDto);		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/productlist.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
