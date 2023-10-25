package com.kkj.cbcomment.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kkj.cbcomment.dao.CbCommentDao;
import com.kkj.cbcomment.dto.CbCommentUpdateDto;

/**
 * Servlet implementation class CbCommentUpdate
 */
public class CbCommentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CbCommentUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("댓글업데이트!!!");
		int cbCommentNo = Integer.parseInt(request.getParameter("cbCommentNo"));
		String cbCommentUpdate = request.getParameter("cbCommentUpdate");
		
		CbCommentUpdateDto cbCommentUpdateDto = new CbCommentUpdateDto();
		cbCommentUpdateDto.setNo(cbCommentNo);
		cbCommentUpdateDto.setCbCommentUpdate(cbCommentUpdate);
		CbCommentDao cbCommentDao = new CbCommentDao();
		int result = cbCommentDao.update(cbCommentUpdateDto);
		if(result > 0) {
			System.out.println("댓글 업데이트 성공");
		}else {
			System.out.println("댓글 업데이트 실패");
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
