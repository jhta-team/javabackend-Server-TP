package com.kkj.cart.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kkj.cart.dao.CartDao;
import com.kkj.cart.dao.CartProductDao;
import com.kkj.cart.dto.CartDto;
import com.kkj.cart.dto.CartProductDto;
import com.kkj.product.util.ScriptWriter;


public class CartProductInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CartProductInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pdtId = Integer.parseInt(request.getParameter("pdtId"));
		int quantity =Integer.parseInt(request.getParameter("quantity"));
		String pickSize = request.getParameter("pdtSize");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("loggedID");
		
		// 카트 객체 생성후 세션에 저장된 userid로 cartid 조회
		CartDao cartDao = new CartDao();
		CartDto cartDto = cartDao.findUserCart(userId);
		int cartId = cartDto.getCartId();
		
		// 카트상품 객체 생성후 데이터 저장, 카트상품 테이블에 상품 추가
		CartProductDto cartProductDto = new CartProductDto();
		cartProductDto.setPdtId(pdtId);
		cartProductDto.setQuantity(quantity);
		cartProductDto.setPickSize(pickSize);
		cartProductDto.setCartId(cartId);
		CartProductDao cartProductDao = new CartProductDao();
		int result = cartProductDao.insertCart(cartProductDto);		
		
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "장바구니 등록 완료", "../cart/list");
		} else {
			ScriptWriter.alertAndBack(response, "오류");
		}
		
	}

}
