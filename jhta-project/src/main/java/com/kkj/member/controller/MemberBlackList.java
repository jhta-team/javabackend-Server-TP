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
import com.kkj.member.dto.MemberDto;

/**
 * Servlet implementation class MemberBalckList
 */
public class MemberBlackList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberBlackList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDao memberDao = new MemberDao();
		HashMap<String, Integer> map = new HashMap();
		String strPage = request.getParameter("page");
		int totalCount = memberDao.blackMemberCount();
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
		List<MemberDto> blackList = memberDao.blackListMember(map);
		if(blackList!=null) {
			
		
		request.setAttribute("intpage", intpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("blackList", blackList);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/member/blackList.jsp");
		dispatcher.forward(request, response);
		if(session.getAttribute("modalState")!=null) {
			session.removeAttribute("modalState");
		}else {
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
