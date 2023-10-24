package com.kkj.cblike.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kkj.cblike.dao.CbLikeDao;
import com.kkj.cblike.dto.CbLikeDto;

/**
 * Servlet implementation class cbLike
 */
public class cbLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cbLike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cbNo = Integer.parseInt(request.getParameter("cbNo"));
		String userID = request.getParameter("userID");
		
		CbLikeDao cbLikeDao = new CbLikeDao();
		CbLikeDto cbLikeDto = new CbLikeDto();
		cbLikeDto.setCbNo(cbNo);
		cbLikeDto.setUserID(userID);
		int findOne = cbLikeDao.findOne(cbLikeDto);
		if(findOne >0) {
			int result = cbLikeDao.insetLike(cbLikeDto);
			if(result > 0) {
				System.out.println("좋아요 올라간다.");
			}else {
				System.out.println("이건 몰라요... 오류에요...");
			}			
		}else {
			int result = cbLikeDao.delete(cbLikeDto);
			if(result > 0) {
				System.out.println("좋아요 취소!!");
			}
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
