package com.kkj.product.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kkj.product.dao.ProductDao;
import com.kkj.product.dao.ProductSizeDao;
import com.kkj.product.dto.ProductDto;
import com.kkj.product.dto.ProductSizeDto;

public class ProductModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductModify() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pdtId = Integer.parseInt(request.getParameter("pdtId"));
		ProductDao pdtDao = new ProductDao();
		ProductDto pdtDto = pdtDao.selectOneProduct(pdtId);
		request.setAttribute("Product", pdtDto);

		ProductSizeDao productSizeDao = new ProductSizeDao();
		ProductSizeDto productSizeDto = new ProductSizeDto();
		productSizeDto = productSizeDao.selectProductSize(pdtId);
		request.setAttribute("productSizeDto", productSizeDto);
		System.out.println("이거" + productSizeDto.getPdtCountL());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/productmodify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
