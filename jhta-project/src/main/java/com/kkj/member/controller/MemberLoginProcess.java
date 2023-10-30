package com.kkj.member.controller;


import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;


import com.kkj.member.dao.MemberDao;
import com.kkj.member.dao.MemberDateDao;
import com.kkj.member.dto.MemberDto;
import com.kkj.member.dto.ModalState;
import com.kkj.product.util.CookieManager;
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
		String check = request.getParameter("check");
		System.out.println(userID+"==="+userPW);
		
		MemberDao memberDao = new MemberDao();
		MemberDateDao MemberDateDao = new MemberDateDao();
		MemberDto loginMember =new MemberDto();
		HashMap<String,String> loginMap = new HashMap();
		loginMap.put("userID", userID);
		loginMap.put("userPW", userPW);
		loginMember = memberDao.loginMember(loginMap);
		if(loginMember !=null) {
			MemberDateDao.loginDate(userID);
			if(loginMember.getAdminNumber()==6) {
				ModalState modalState = new ModalState("show","블랙입니다. 관리자에게 문의하세요");
				session.setAttribute("modalState", modalState);
				response.sendRedirect("../member/login");
			}else {
				String loggedName = loginMember.getUserName();
				
				session.setAttribute("loggedID", userID);
				session.setAttribute("loggedName",loggedName);
				session.setAttribute("loggedMember", loginMember);
				
				ModalState modalState = new ModalState("show","로그인 성공");
				session.setAttribute("modalState", modalState);				
				if(check !=null) {
					CookieManager.createCookie(response, "cookieID", userID, 60*60*24);
					String cookieID = CookieManager.readCookie(request, "cookieID");
					request.setAttribute("cookieID", cookieID);
				}else {
					CookieManager.deleteCookie(response, "cookieID");
				}			
				response.sendRedirect("../index/index");				
			}
		}else{
			ScriptWriter.alertAndBack(response, "아이디와 비밀번호를 확인해주세요");
		}
		
	}

}
