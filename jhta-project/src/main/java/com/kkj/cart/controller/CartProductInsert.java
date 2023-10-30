package com.kkj.cart.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kkj.cart.dao.CartProductDao;
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
		
		CartProductDto cartProductDto = new CartProductDto();
		cartProductDto.setPdtId(pdtId);
		cartProductDto.setQuantity(quantity);
		cartProductDto.setPickSize(pickSize);
		CartProductDao cartProductDao = new CartProductDao();
		int result = cartProductDao.insertCart(cartProductDto);		
		
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "장바구니 등록 완료", "../cart/list");
		} else {
			ScriptWriter.alertAndBack(response, "오류");
		}
		
	}

}
