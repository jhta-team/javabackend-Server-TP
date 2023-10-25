package com.kkj.cbreply.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kkj.cbreply.dao.CbReplyDao;
import com.kkj.cbreply.dto.CbReplyUpdateDto;

/**
 * Servlet implementation class CbReplyUpdate
 */
public class CbReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CbReplyUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		String replyUpdate = request.getParameter("replyUpdate");
		System.out.println(replyNo);
		System.out.println(replyUpdate);
		CbReplyUpdateDto cbReplyUpdateDto = new CbReplyUpdateDto();
		cbReplyUpdateDto.setNo(replyNo);
		cbReplyUpdateDto.setReplyUpdate(replyUpdate);
		
		CbReplyDao cbReplyDao = new CbReplyDao();
		int result = cbReplyDao.update(cbReplyUpdateDto);
		if(result > 0) {
			System.out.println("등록성공");
		}else {
			System.out.println("등록실패");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
