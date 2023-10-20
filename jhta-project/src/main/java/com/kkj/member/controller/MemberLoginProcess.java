package com.kkj.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.kkj.member.dao.MemberDao;
import com.kkj.member.dto.MemberDto;


public class MemberLoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberLoginProcess() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String check = request.getParameter("check");
		System.out.println(userID+"==="+userPW);
		MemberDao memberDao = new MemberDao();
		MemberDto loginMemberDto =null;
		HashMap<String,String> loginMap = new HashMap<String, String>();
		loginMap.put("userID", userID);
		loginMap.put("userPW", userPW);
		loginMemberDto = memberDao.loginMember(loginMap);
		System.out.println(loginMemberDto.getUserID());
		String loggedName = loginMemberDto.getUserName();
		if(loginMemberDto!=null) {
			session.setAttribute("loggedID", userID);
			session.setAttribute("loggedName", loggedName);
			request.setAttribute("loginMemberDto", loginMemberDto);
			response.sendRedirect("../index/index");
		}
		
	}

}
