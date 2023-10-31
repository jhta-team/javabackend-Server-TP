package com.kkj.cart.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.kkj.cart.dao.CartProductDao;
import com.kkj.cart.dto.CartProductDto;
import com.kkj.product.util.ScriptWriter;

public class CartProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartProductDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cartItemId = Integer.parseInt(request.getParameter("cartItemId"));

        CartProductDao cartProductDao = new CartProductDao();
        int result = cartProductDao.deleteCart(cartItemId);
        if(result > 0) {
            Map<String, Integer> resultMap = new HashMap<>();
            resultMap.put("result", result);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            Gson gson = new Gson();
            String resultJson = gson.toJson(resultMap);

            response.getWriter().write(resultJson);
        } else {
        	ScriptWriter.alertAndBack(response, "서버 오류");
        }
    }
}
