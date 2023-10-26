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
		HashMap<String,Integer> map = new HashMap();
		//ArrayList<HashMap<String,Integer>> list = new ArrayList();
		MemberDao memberDao = new MemberDao();
		
		for(int i=0;i<idx.length;i++) {
			map.put("no", Integer.parseInt(idx[i]));
			int result = memberDao.blackUpdateAll(map);
		}
		HashMap<String,Boolean> isMap = new HashMap();
		isMap.put("isBalck", true);
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
