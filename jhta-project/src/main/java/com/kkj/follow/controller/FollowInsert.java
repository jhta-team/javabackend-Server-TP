package com.kkj.follow.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import com.google.gson.Gson;
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
		followDao.checked(followDto);
		HashMap<String, Integer> resMap = new HashMap<String, Integer>();
		int follow = 0;
		int follower = 0;
		if(followDao.checked(followDto)) {
			resMap = followDao.delete(followDto);
			
			resMap.put("status", 0);
//			resMap.put("followCount", follow);
//			resMap.put("followerCount", follower);
			
		}else {
			try {
				resMap = followDao.insert(followDto);
				System.out.println("추가 !!!");
				follow = followDao.followCount(followDto.getMyID());
				follower = followDao.followerCount(followDto.getFollowID());
				resMap.put("status", 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			resMap.put("followCount", follow);
//			resMap.put("followerCount", follower);
		}
		Gson gson = new Gson();
		String res = (String)gson.toJson(resMap);
		request.setAttribute("res", res);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/follow/followjson.jsp");
		dispatcher.forward(request, response);
		
	}

}
