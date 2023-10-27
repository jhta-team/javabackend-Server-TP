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
import java.util.List;

import com.kkj.member.dao.MemberDao;
import com.kkj.member.dao.MemberDateDao;
import com.kkj.member.dto.MemberDateDto;
import com.kkj.member.dto.MemberDto;

/**
 * Servlet implementation class MemberList
 */
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDao memberDao = new MemberDao();
		MemberDateDao memberDateDao = new MemberDateDao();
		
		HashMap<String, Integer> map = new HashMap();
		map.put("start", 1);
		map.put("end", 10);
		List<MemberDto> memberList = memberDao.listMember(map);
		MemberDateDto memberDateDto  = memberDateDao.loginCount();
		int insertCount	= memberDao.insertCount();
		int memberCount = memberDao.memberCount();
		int loginNO = memberDateDto.getCount();
		request.setAttribute("memberList", memberList);
		request.setAttribute("loginNO", loginNO);
		request.setAttribute("insertCount", insertCount);
		request.setAttribute("memberCount", memberCount);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/member/memberList.jsp");
		dispatcher.forward(request, response);
		if(session.getAttribute("modalState")!=null) {
			session.removeAttribute("modalState");
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
