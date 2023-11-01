package com.kkj.follow.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.kkj.follow.dao.FollowDao;
import com.kkj.follow.dto.FollowDto;

/**
 * Servlet implementation class FollowInsert
 */
public class FollowInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String followID = request.getParameter("followID");
		String myID = "aaa";
		
		FollowDto followDto = new FollowDto();
		FollowDao followDao = new FollowDao();
		followDto.setFollowID(followID);
		followDto.setMyID(myID);
		
		System.out.println(followDto.getFollowID());
		System.out.println(followDto.getMyID());
		
		if(followDao.checked(followDto)) {
			followDao.delete(followDto);
			System.out.println("삭제!!!");
			
		}else {
			followDao.insert(followDto);
			System.out.println("추가 !!!");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.append("add");
			
			
		}
		
		
	}

}
