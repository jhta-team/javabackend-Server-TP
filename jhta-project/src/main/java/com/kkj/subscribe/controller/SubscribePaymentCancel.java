package com.kkj.subscribe.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kkj.subscribe.dao.SubscribeCancelDao;
import com.kkj.subscribe.dto.SubscribePaymentDto;
import com.kkj.subscribe.dto.UpdateSubscribeDto;




/**
 * Servlet implementation class SubscribePaymentCancel
 */
public class SubscribePaymentCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscribePaymentCancel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userID = request.getParameter("userID");
			int price = Integer.parseInt(request.getParameter("price"));
			String imp_uid = request.getParameter("imp_uid");
			String product = request.getParameter("product");
			String status = request.getParameter("status");
			
			SubscribePaymentDto subscribePaymentDto = new SubscribePaymentDto();
			subscribePaymentDto.setUserID(userID);
			subscribePaymentDto.setPrice(price);
			subscribePaymentDto.setImp_uid(imp_uid);
			subscribePaymentDto.setProduct(product);
			subscribePaymentDto.setStatus(status);
			SubscribeCancelDao subscribeCancelDao = new SubscribeCancelDao();
			UpdateSubscribeDto updateSubscribeDto  = new UpdateSubscribeDto(); 
			int result1 = subscribeCancelDao.insert(subscribePaymentDto);
			if(result1 > 0) {
				updateSubscribeDto = subscribeCancelDao.findOne(userID);
				updateSubscribeDto = subscribeCancelDao.changeDay(updateSubscribeDto,product);
				int result2 = subscribeCancelDao.update(updateSubscribeDto);
				if(result2 > 0) {
					System.out.println("환불완료 날짜까지 변경완료");
				}
			}
			
		}catch(Exception e) {
			throw e;
		}
		
		
	}

}
