package com.kkj.cart.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.lang.model.element.QualifiedNameable;

import com.google.gson.Gson;
import com.kkj.cart.dao.CartProductDao;
import com.kkj.cart.dto.CartProductDto;
import com.kkj.product.dao.ProductDao;
import com.kkj.product.dao.ProductSizeDao;
import com.kkj.product.dto.ProductDto;
import com.kkj.product.dto.ProductSizeDto;
import com.kkj.product.util.ScriptWriter;

public class CartProductModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartProductModify() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cartItemId = Integer.parseInt(request.getParameter("cartItemId"));
		String pickSize = request.getParameter("pickSize");
		String strQuantity = request.getParameter("newQuantity");
		int quantity = 0;
		if(strQuantity !=null && !strQuantity.isEmpty()) {
			quantity = Integer.parseInt(strQuantity);
	    }
		int pdtId = Integer.parseInt(request.getParameter("pdtId"));
		int pdtCount = 0;

		
		Map<String, Object> resultMap = new HashMap<>();
		
		//사이즈 수정
		ProductSizeDao productSizeDao = new ProductSizeDao();
		ProductSizeDto productSizeDto = productSizeDao.selectProductSize(pdtId);
		System.out.println("pickSize = " + pickSize);
		switch (pickSize) {
		case "S":
			pdtCount = productSizeDto.getPdtCountS();
			break;
		case "M":
			pdtCount = productSizeDto.getPdtCountM();
			break;
		case "L":
			pdtCount = productSizeDto.getPdtCountL();
			break;
		case "XL":
			pdtCount = productSizeDto.getPdtCountXL();
			break;
		}		

		System.out.println("quantity : " + quantity);
		System.out.println("pdtCount : " + pdtCount);
		
		if (quantity > pdtCount) {
		    // 주문수량이 재고보다 더 많을 때
		    resultMap.put("result", "fail");
		    resultMap.put("previousQuantity", quantity); // 클라이언트에서 이전 값으로 복원할 수 있도록 전달
		    System.out.println("실패1");
		} else {
		    // 주문수량이 재고보다 적을 때
		    CartProductDao cartProductDao = new CartProductDao();
		    CartProductDto cartProductDto = new CartProductDto();
		    cartProductDto.setCartItemId(cartItemId);
		    cartProductDto.setQuantity(quantity);
		    System.out.println(cartProductDto.getCartItemId());
		    System.out.println(cartProductDto.getQuantity());
		    int result = cartProductDao.updateCart(cartProductDto);

		    if (result > 0) {
		        resultMap.put("result", "success");
		        System.out.println("성공");
		    } else {
		        resultMap.put("result", "fail");
			    System.out.println("실패2");
		    }
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		Gson gson = new Gson();
		String resultJson = gson.toJson(resultMap);

		response.getWriter().write(resultJson);

	}

}
