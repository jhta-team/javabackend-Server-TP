package com.kkj.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.kkj.member.dao.MemberDao;

/**
 * Servlet implementation class MemberLevelAll
 */
public class MemberLevelAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLevelAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no=0;
		int ad=0;
		String strNo[] = request.getParameterValues("no");
		String level = request.getParameter("level");
		HashMap<String,Integer> map = new HashMap();
		HashMap<String,Boolean> ismap = new HashMap();
		MemberDao memberDao = new MemberDao();
		if(level.equals("silver")) {
			ad=2;
		}else if(level.equals("gold")){
			ad=3;
		}else if(level.equals("ple")){
			ad=4;
		}else if(level.equals("diamond")){
			ad=5;
		}else if(level.equals("admin")) {
			ad=1;
		}else {
			ad=0;
		}
		map.put("adminNumber", ad);
		if(strNo !=null && strNo.length>0) {
			for(int i=0;i<strNo.length;i++) {
				map.put("no", Integer.parseInt(strNo[i]));
				int result = memberDao.blackUpdateAll(map);
			}
			ismap.put("isLevel", true);	
		}else {
			ismap.put("isLevel", false);	
		}
		Gson gson = new Gson();
		String json = (String)gson.toJson(ismap);
		request.setAttribute("json", json);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/levelCheck.jsp");
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
