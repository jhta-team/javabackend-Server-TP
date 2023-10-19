package com.kkj.product.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kkj.product.dao.ProductDao;
import com.kkj.product.dto.ProductDto;

public class ProductListProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductListProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao pdtDao = new ProductDao();
		List<ProductDto> listDto = new ArrayList<ProductDto>();
		listDto = pdtDao.listProduct();
		request.setAttribute("ProductList", listDto);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
