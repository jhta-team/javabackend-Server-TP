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
 * Servlet implementation class MemberLevel
 */
public class MemberLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLevel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String level = request.getParameter("level");
		
		String noList[] =level.split(",");
		String realLevel=noList[0];

		String strNo =  level.substring(3);
		System.out.println(strNo);
		System.out.println(realLevel);
		int no=0;
		int ad =0;
		if(strNo!=null && !strNo.isEmpty()) {
			no=Integer.parseInt(strNo);
		}
		if(realLevel!=null && !realLevel.isEmpty()) {
			
			if(realLevel.equals("si")) {
				ad=2;
			}else if(realLevel.equals("go")) {
				ad=3;
			}else if(realLevel.equals("pl")) {
				ad=4;
			}else if(realLevel.equals("di")){
				ad=5;
			}			
		}
		MemberDao memberDao = new MemberDao();
		HashMap<String,Integer> map = new HashMap();
		HashMap<String,Boolean> ismap = new HashMap();
		map.put("adminNumber", ad);
		map.put("no", no);
		int result =memberDao.blackUpdate(map);
		if(result>0) {
			ismap.put("isLevel", true);
			Gson gson = new Gson();
			String json = (String)gson.toJson(ismap);
			request.setAttribute("json", json);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/levelCheck.jsp");
			dispatcher.forward(request, response);
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
