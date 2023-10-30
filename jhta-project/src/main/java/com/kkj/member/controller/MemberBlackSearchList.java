package com.kkj.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.kkj.member.dao.MemberDao;
import com.kkj.member.dao.MemberDateDao;
import com.kkj.member.dto.MemberDto;

/**
 * Servlet implementation class MemberBlackSearchList
 */
public class MemberBlackSearchList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberBlackSearchList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search"); //카테고리
		String searchword = request.getParameter("searchword");
		String strPage = request.getParameter("page");
		MemberDateDao memberDateDao = new MemberDateDao();
		MemberDao memberDao = new MemberDao();
		HashMap<String,Object> totalmap = new HashMap();
		totalmap.put("search", search);
		totalmap.put("searchword", searchword);
		int totalCount = memberDao.blackSearhMemberCount(totalmap);
		int intpage =0;
		int lastpage = 10;
		int totalpage =(int)Math.ceil(totalCount/(double)lastpage);
		if(strPage==null || strPage.isEmpty()) {
			intpage =1;
			
		}else {
			intpage =  Integer.parseInt(strPage);
		}
		if(totalpage <= intpage) {
			intpage = totalpage;
		}
		int startpage = ((intpage-1)/lastpage)*lastpage+1;
		int endpage = startpage + lastpage -1;
		if(endpage > totalpage) {
			endpage =totalpage;
		}
		HashMap<String,Object> map = new HashMap();
		map.put("search", search);
		map.put("searchword", searchword);
		map.put("start", (intpage-1)*10 +1);
		map.put("end", intpage*10);
		List<MemberDto> blackList = memberDao.blackSearhMember(map);
		int loginCount  = memberDateDao.loginCount();
		int insertCount	= memberDao.insertCount();
		int memberCount = memberDao.memberCount();
		request.setAttribute("search", search);
		request.setAttribute("searchword", searchword);
		request.setAttribute("intpage", intpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("blackList", blackList);
		request.setAttribute("loginCount", loginCount);
		request.setAttribute("insertCount", insertCount);
		request.setAttribute("memberCount", memberCount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/blackSearchList.jsp");
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
