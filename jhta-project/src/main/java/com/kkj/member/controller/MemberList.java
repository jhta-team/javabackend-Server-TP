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
		String strPage = request.getParameter("page");
		
		int totalCount = memberDao.noBlackMemberCount();
		int intpage =0;
		int lastpage = 10;
		int totalpage =(int)Math.ceil(totalCount/(double)lastpage);
		if(strPage==null || strPage.isEmpty()) {
			intpage =1;
			
		}else {
			intpage =  Integer.parseInt(strPage);
		}
		if(totalpage < intpage) {
			intpage = totalpage;
		}
		int startpage = ((intpage-1)/lastpage)*lastpage+1;
		int endpage = startpage + lastpage -1;
		if(endpage > totalpage) {
			endpage =totalpage;
		}
		map.put("start", (intpage-1)*10 +1);
		map.put("end", intpage*10);
		List<MemberDto> memberList = memberDao.listMember(map);
		if(memberList != null) {	
		int loginCount  = memberDateDao.loginCount();
		int insertCount	= memberDao.insertCount();
		int memberCount = memberDao.memberCount();
	
		request.setAttribute("intpage", intpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("memberList", memberList);
		request.setAttribute("loginCount", loginCount);
		request.setAttribute("insertCount", insertCount);
		request.setAttribute("memberCount", memberCount);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/member/memberList.jsp");
		dispatcher.forward(request, response);
		if(session.getAttribute("modalState")!=null) {
			session.removeAttribute("modalState");
		}
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
