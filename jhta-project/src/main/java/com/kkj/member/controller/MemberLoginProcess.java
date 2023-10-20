package com.kkj.member.controller;


import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;


import com.kkj.member.dao.MemberDao;
import com.kkj.member.dto.MemberDto;
import com.kkj.product.util.ScriptWriter;


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
		System.out.println(userID+"==="+userPW);
		
		MemberDao memberDao = new MemberDao();
		MemberDto loginMemberDto =new MemberDto();
		HashMap<String,String> loginMap = new HashMap();
		loginMap.put("userID", "123");
		loginMap.put("userPW", "123");
		loginMemberDto = memberDao.loginMember(loginMap);
		System.out.println(loginMemberDto.getUserID());
		String loggedName = loginMemberDto.getUserName();
		response.sendRedirect("../index/index");
		
	}

}
