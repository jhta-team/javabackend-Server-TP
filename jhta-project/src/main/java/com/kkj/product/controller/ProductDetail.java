package com.kkj.product.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kkj.product.dao.ImageDao;
import com.kkj.product.dao.ProductDao;
import com.kkj.product.dao.ProductSizeDao;
import com.kkj.product.dto.ImageDto;
import com.kkj.product.dto.ProductDto;
import com.kkj.product.dto.ProductSizeDto;

public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ProductDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pdtId = Integer.parseInt(request.getParameter("pdtId")); // 쿼리스트링으로 받아온 상품 id값 저장
		ProductDao detailDao = new ProductDao();
		ProductDto detailDto = new ProductDto();
		detailDto = detailDao.detailProduct(pdtId); 
		request.setAttribute("detailDto", detailDto); //제품상세보기 정보 저장
		//System.out.println(detailDto.toString());
		
		//상품이미지 
		ImageDao imageDao = new ImageDao();
		ImageDto imageDto = new ImageDto();
		imageDto = imageDao.selectOneImg(pdtId);
		request.setAttribute("imageDto", imageDto);
		
		ProductSizeDto productSizeDto = new ProductSizeDto();
		ProductSizeDao productSizeDao = new ProductSizeDao();
		productSizeDto = productSizeDao.selectProductSize(pdtId);
		request.setAttribute("productSizeDto", productSizeDto);
		


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/productdetail.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
