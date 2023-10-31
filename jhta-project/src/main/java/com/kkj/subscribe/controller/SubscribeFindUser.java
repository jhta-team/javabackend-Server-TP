package com.kkj.subscribe.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.kkj.subscribe.dao.SubscribeDao;
import com.kkj.subscribe.dto.SubscribePaymentDto;

/**
 * Servlet implementation class SubscribeFind
 */
public class SubscribeFindUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscribeFindUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SubscribeDao subscribeDao = new SubscribeDao();
		String userID = "mok119";
		List<SubscribePaymentDto> subscribePaymentList = subscribeDao.find(userID);
		System.out.println("여기!!!!!!!!!!!!!");
		System.out.println(subscribePaymentList);
		System.out.println("여기!!!!!!!!!!!!!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/subscribe/find.jsp");
		request.setAttribute("subscribePaymentList", subscribePaymentList);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
