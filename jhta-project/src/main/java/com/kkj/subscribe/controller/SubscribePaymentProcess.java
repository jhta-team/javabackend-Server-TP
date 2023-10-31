package com.kkj.subscribe.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import com.kkj.subscribe.dao.SubscribeDao;
import com.kkj.subscribe.dto.SubscribePaymentDto;
import com.kkj.subscribe.dto.UpdateSubscribeDto;

/**
 * Servlet implementation class SubscribePaymentProcess
 */
public class SubscribePaymentProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscribePaymentProcess() {
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
		String userID = request.getParameter("userID");
		int price = Integer.parseInt(request.getParameter("price"));
		String imp_uid = request.getParameter("imp_uid");
		String product = request.getParameter("product");
		String status = request.getParameter("status");
		
		
		
		SubscribePaymentDto subscribeDto = new SubscribePaymentDto();
		UpdateSubscribeDto updateSubscribeDto = new UpdateSubscribeDto();
		subscribeDto.setUserID(userID);
		subscribeDto.setPrice(price);
		subscribeDto.setImp_uid(imp_uid);
		subscribeDto.setProduct(product);
		subscribeDto.setStatus(status);
		
		SubscribeDao subscribeDao = new SubscribeDao();
		String mySubscribeEnd = subscribeDao.subscribeDayFind(userID); // 디비에서 가져온 날짜!!!
		
		
		int check = subscribeDao.check(imp_uid);
		try {
			if(check == 0) {
				int result = subscribeDao.payment(subscribeDto);
				System.out.println("result =>>>>" + result);
				if(result > 0) {
					String changeDay = "";
					int checked = subscribeDao.checkday(mySubscribeEnd); // 현재시간과 디비의 시간 비교
					System.out.println("checked?=>>>>" + checked);
					if(checked == 1 || checked == 0) { // 현재시간이 더 크다 디비 시간보다 그렇다면 재구독 or 신규구독 
						changeDay = subscribeDao.plusDay(product);
						System.out.println("checked1or0=>>>>" +changeDay);
					}else { //추가구독
						changeDay = subscribeDao.addSubscribe(product, mySubscribeEnd);
						System.out.println("checked -1 =>>>>" +changeDay);
					}
					if(!changeDay.isEmpty()) {
						updateSubscribeDto.setId((userID));
						updateSubscribeDto.setSubscribeEnd(changeDay);
						int update = subscribeDao.updateSubscribeEnd(updateSubscribeDto);
						if(update > 0) {
							System.out.println("업데이트성공");
						}
					}
					System.out.println("결제성공");
				}
			}
			
		}catch(Exception e) {
			Gson gson = new Gson();
			String failedPayment = gson.toJson(imp_uid);
			System.out.println(failedPayment);
			request.setAttribute("imp_uid", failedPayment);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/subscribe/paymentfailed.jsp");
			dispatcher.forward(request, response);
		}
	}

}
