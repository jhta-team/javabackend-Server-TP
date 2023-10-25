package com.kkj.cbcomment.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kkj.cbcomment.dao.CbCommentDao;

/**
 * Servlet implementation class CbCommentDelete
 */
public class CbCommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CbCommentDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cbCommentNo = Integer.parseInt(request.getParameter("cbCommentNo"));
		System.out.println(cbCommentNo);
		CbCommentDao cbCommentDao = new CbCommentDao();
		int result = cbCommentDao.delete(cbCommentNo);
		if(result > 0) {
			System.out.println("댓글 삭제 성공");
		}else {
			System.out.println("댓글 삭제 실패");
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
