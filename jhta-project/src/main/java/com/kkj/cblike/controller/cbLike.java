package com.kkj.cblike.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.kkj.cblike.dao.CbLikeDao;
import com.kkj.cblike.dto.CbLikeDto;

/**
 * Servlet implementation class cbLike
 */
public class cbLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cbLike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cbNo = Integer.parseInt(request.getParameter("cbNo"));
		String userID = request.getParameter("userID");
		
		CbLikeDao cbLikeDao = new CbLikeDao();
		CbLikeDto cbLikeDto = new CbLikeDto();
		cbLikeDto.setCbNo(cbNo);
		cbLikeDto.setUserID(userID);
		int findOne = cbLikeDao.findOne(cbLikeDto);
		Map<String, Integer> cbLikeCount = new HashMap<String, Integer>();
		if(findOne >0) {
			int result = cbLikeDao.insetLike(cbLikeDto);
			if(result > 0) {
			}else {
				System.out.println("이건 몰라요... 오류에요...");
			}			
		}else {
			int result = cbLikeDao.delete(cbLikeDto);
			if(result > 0) {
				System.out.println("좋아요 취소!!");
//				PrintWriter out = response.getWriter();
//				out.append("1");
			}
		}
		int count = cbLikeDao.findCount(cbNo);
		cbLikeCount.put("count", count);
		Gson gson = new Gson();
		String json = (String)gson.toJson(cbLikeCount);
		request.setAttribute("json", json);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cblike/cblikecount.jsp");
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
