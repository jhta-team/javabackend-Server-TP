package com.kkj.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.kkj.member.dao.MemberDao;

/**
 * Servlet implementation class MemberBlack
 */
public class MemberBlack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberBlack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		int no=0;
		String strNo = request.getParameter("no");
		if(strNo!=null && !strNo.isEmpty()) {
			no=Integer.parseInt(strNo);
		}
		
		int result = memberDao.blackUpdate(no);
		
		HashMap<String,Boolean> map = new HashMap();
		if(result>0) {
			map.put("isBalck", true);
			Gson gson = new Gson();
			String json = (String)gson.toJson(map);
			request.setAttribute("json", json);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/blackCheck.jsp");
			dispatcher.forward(request, response);
		}else {
			
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
