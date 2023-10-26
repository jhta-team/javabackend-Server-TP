package com.kkj.cbreply.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.kkj.cbreply.dao.CbReplyDao;
import com.kkj.cbreply.dto.CbReplyDto;

/**
 * Servlet implementation class CbReplyInsert
 */
public class CbReplyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CbReplyInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String replyUserID = request.getParameter("replyUserID");
		String reply = request.getParameter("reply");
		int codyBoardNo = Integer.parseInt(request.getParameter("codyBoardNo"));
		int cbCommentNo = Integer.parseInt(request.getParameter("cbCommentNo"));
		
		CbReplyDto cbReplyDto = new CbReplyDto();
		cbReplyDto.setReplyUserID(replyUserID);
		cbReplyDto.setReply(reply);
		cbReplyDto.setCbCommentNo(cbCommentNo);
		cbReplyDto.setCodyBoardNo(codyBoardNo);

		CbReplyDao cbReplyDao = new CbReplyDao();
	
		int result = cbReplyDao.insert(cbReplyDto);
		if(result > 0) {
			System.out.println("등록성");
			Gson gson = new Gson();
			String cbReply = (String)gson.toJson(cbReplyDto);
			System.out.println(cbReply);
			request.setAttribute("reply", cbReply);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cbreply/reply.jsp");
			dispatcher.forward(request, response);
		}else {
			System.out.println("등록실패@@");
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
