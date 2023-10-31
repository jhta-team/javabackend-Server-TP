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
import com.kkj.subscribe.dto.SubscribeDto;

/**
 * Servlet implementation class SubscribePayment
 */
public class SubscribePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscribePayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SubscribeDao subscribe = new SubscribeDao();
		List<SubscribeDto> subscribeKind = subscribe.find();
		request.setAttribute("subscribeKind", subscribeKind);
		System.out.println(subscribeKind);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/subscribe/payment.jsp");
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
