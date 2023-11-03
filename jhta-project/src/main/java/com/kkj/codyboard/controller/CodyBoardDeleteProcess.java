package com.kkj.codyboard.controller;

import jakarta.el.ELException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kkj.codyboard.dao.CodyBoardDao;

/**
 * Servlet implementation class CodyBoardDeleteProcess
 */
public class CodyBoardDeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodyBoardDeleteProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codyBoardNo =  Integer.parseInt(request.getParameter("codyBoardNo"));
		CodyBoardDao codyBoardDao = new CodyBoardDao();
		CodyBoardImage codyBoardImage = new CodyBoardImage();
		
		try {
			codyBoardDao.delete(codyBoardNo);
			codyBoardImage.delete(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ELException();
			
			
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
