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
		MemberDao memberDao = new MemberDao();
		HashMap<String, Integer> map = new HashMap();
		map.put("start", 1);
		map.put("end", 10);
		List<MemberDto> blackList = memberDao.blackListMember(map);
		request.setAttribute("blackList", blackList);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/member/blackList.jsp");
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
