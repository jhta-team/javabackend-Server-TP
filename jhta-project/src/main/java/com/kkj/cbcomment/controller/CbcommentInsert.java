package com.kkj.cbcomment.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.kkj.cbcomment.dao.CbCommentDao;
import com.kkj.cbcomment.dto.CbCommentDto;

/**
 * Servlet implementation class CbcommentInsert
 */
public class CbcommentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CbcommentInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String comment = request.getParameter("comment");
		int codyBoardNo = Integer.parseInt(request.getParameter("codyBoardNo"));
		CbCommentDao cbCommentDao = new CbCommentDao();
		CbCommentDto cbCommentDto = new CbCommentDto();
		System.out.println(userID + "===" + comment + "=====" + codyBoardNo);
		cbCommentDto.setUserID(userID);
		cbCommentDto.setComment(comment);
		cbCommentDto.setCodyBoardNo(codyBoardNo);
		LocalDateTime nowTime = LocalDateTime.now();
		System.out.println(nowTime);
		int result = cbCommentDao.insert(cbCommentDto);
		if(result > 0) {
			System.out.println("등록성공!!!");
			Gson gson = new Gson();
			String commentData = (String)gson.toJson(cbCommentDto);
			request.setAttribute("commentData", commentData);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cbcomment/cbcommentdata.jsp");
			dispatcher.forward(request, response);
		}else {
			System.out.println("등록실패!!!");
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
