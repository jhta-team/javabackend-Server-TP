package com.kkj.codyboard.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kkj.codyboard.dao.CodyBoardDao;

/**
 * Servlet implementation class CodyBoardDelete
 */
public class CodyBoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodyBoardDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codyBoardNo = Integer.parseInt(request.getParameter("no"));
		System.out.println(codyBoardNo);
		CodyBoardImage codyBoardImage = new CodyBoardImage();	
		CodyBoardDao codyBoardDao = new CodyBoardDao();
		int result = codyBoardDao.delete(codyBoardNo);
		
		if(result > 0) {
			if(codyBoardImage.delete(request,response)) {
				System.out.println("삭제성공");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/codyboard/page-nation");
				dispatcher.forward(request, response);
				
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
