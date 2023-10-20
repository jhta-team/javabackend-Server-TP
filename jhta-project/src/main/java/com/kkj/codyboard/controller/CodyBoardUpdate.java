package com.kkj.codyboard.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kkj.codyboard.dao.CodyBoardDao;
import com.kkj.codyboard.dto.CodyBoardDto;

/**
 * Servlet implementation class CodyBoardUpdate
 */
public class CodyBoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodyBoardUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codyBoardNo = Integer.parseInt(request.getParameter("no"));
		CodyBoardDao codyBoardDao = new CodyBoardDao();
		CodyBoardDto codyBoardDto = new CodyBoardDto();
		System.out.println("sad");
		codyBoardDto = codyBoardDao.findOne(codyBoardNo);
		request.setAttribute("codyBoard", codyBoardDto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/codyboard/update.jsp");
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
