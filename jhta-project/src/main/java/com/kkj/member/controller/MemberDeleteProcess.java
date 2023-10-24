package com.kkj.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.kkj.member.dao.MemberDao;
import com.kkj.member.dto.MemberDto;
import com.kkj.product.util.ScriptWriter;

/**
 * Servlet implementation class MemberDeleteProcess
 */
public class MemberDeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteProcess() {
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
		HttpSession session = request.getSession();
		String userID =(String)session.getAttribute("loggedID");
		String userName =(String)session.getAttribute("loggedName");
		String userPW = request.getParameter("userPW");
		MemberDao memberDao = new MemberDao();
		MemberDto deleteMembetDto = (MemberDto)session.getAttribute("loggedMember");
		String profile = deleteMembetDto.getProfile();
		String uplodaPath = "C:\\upload";
		
		HashMap<String,String> deleteMap = new HashMap();
		deleteMap.put("userID", userID);
		deleteMap.put("userPW", userPW);
		int result = memberDao.deleteMember(deleteMap);
		if(result>0) {
			File file = new File(uplodaPath+File.separator+profile);
			if(file.exists()) {
				file.delete();
			}
			session.invalidate();
			 ScriptWriter.alertAndNext(response, userName+"님 회원탈퇴되었습니다", "../index/index");
		}
	}

}
