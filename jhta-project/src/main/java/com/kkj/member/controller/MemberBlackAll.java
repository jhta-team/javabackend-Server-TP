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
 * Servlet implementation class MemberBlackAll
 */
public class MemberBlackAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberBlackAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idx[] = request.getParameterValues("check");
		int ad=0;
		String strAd = request.getParameter("ad");
		if(strAd!=null && !strAd.isEmpty()) {
			ad=Integer.parseInt(strAd);
		}
		HashMap<String,Integer> map = new HashMap();
		HashMap<String,Boolean> isMap = new HashMap();
		MemberDao memberDao = new MemberDao();		
		map.put("adminNumber",ad);
		if(idx !=null && idx.length>0) {
			for(int i=0;i<idx.length;i++) {
				map.put("no", Integer.parseInt(idx[i]));
				int result = memberDao.blackUpdateAll(map);
			}			
			isMap.put("isBalck", true);
		} 
		else{ 
			isMap.put("isBlack", false); 
		}
			 
		Gson gson = new Gson();
		String json = (String)gson.toJson(isMap);
		request.setAttribute("json", json);			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/blackCheckAll.jsp");
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
