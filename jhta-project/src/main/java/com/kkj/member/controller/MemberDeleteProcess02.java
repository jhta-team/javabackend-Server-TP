package com.kkj.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.kkj.member.dao.MemberDao;
import com.kkj.member.dao.MemberDateDao;
import com.kkj.member.dto.MemberDto;

/**
 * Servlet implementation class MemberDeleteProcess02
 */
public class MemberDeleteProcess02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteProcess02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no =0;
		String strNo = request.getParameter("no");
		if(strNo!=null && !strNo.isEmpty()) {
			no = Integer.parseInt(strNo);
		}
		String userID = request.getParameter("userID");
		System.out.print("userID"+userID);
		MemberDao memberDao = new MemberDao();
		MemberDateDao memberDateDao = new MemberDateDao();
		String profile = memberDao.imageMember(no);
		String uplodaPath = "C:\\upload";
		HashMap<String,Boolean> map = new HashMap();
		Gson gson = new Gson();
		String json =null;
		int result = memberDao.deleteAdminMember(no);
		if(result>0) {
			File file = new File(uplodaPath+File.separator+profile);
			if(file.exists()) {
				file.delete();
			}
			memberDateDao.deleteDate(userID);
			map.put("isDelete", true);
			json= (String)gson.toJson(map);
			request.setAttribute("json", json);			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/blackCheckAll.jsp");
			dispatcher.forward(request, response);
		}else {
			map.put("isDelete", false);
			json= (String)gson.toJson(map);
			request.setAttribute("json", json);			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/blackCheckAll.jsp");
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
