package com.kkj.cart.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kkj.cart.dao.CartDao;
import com.kkj.cart.dao.CartProductDao;
import com.kkj.cart.dto.CartDto;
import com.kkj.cart.dto.CartProductDto;
import com.kkj.product.dao.ImageDao;
import com.kkj.product.dao.ProductDao;
import com.kkj.product.dao.ProductSizeDao;
import com.kkj.product.dto.ImageDto;
import com.kkj.product.dto.ProductDto;
import com.kkj.product.dto.ProductSizeDto;

public class CartProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartProductList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("loggedID");
		CartDao cartDao = new CartDao();
		CartDto cartDto = cartDao.findUserCart(userId);	
		int cartId = cartDto.getCartId();
		System.out.println(cartId);
		List<CartProductDto> cartProductDto = new ArrayList<>();		
		CartProductDao cartProductDao = new CartProductDao();
		cartProductDto = cartProductDao.selectListCart(cartId);
		request.setAttribute("CartProductDto", cartProductDto);		
	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cart/cartproductlist.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
