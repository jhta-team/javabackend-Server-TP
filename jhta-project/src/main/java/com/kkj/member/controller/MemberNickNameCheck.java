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
 * Servlet implementation class MemberNickNameCheck
 */
public class MemberNickNameCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberNickNameCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickName = request.getParameter("nickName");
		MemberDao memberDao = new MemberDao();
		int count = memberDao.nickNameCheckMember(nickName);
		HashMap<String, Integer> map = new HashMap();
		map.put("count", count);
		Gson gson = new Gson();
		String json = (String)gson.toJson(map);
		request.setAttribute("json", json);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/nickNameCheck.jsp");
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