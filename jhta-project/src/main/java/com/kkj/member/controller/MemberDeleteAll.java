package com.kkj.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;

import javax.tools.DocumentationTool.Location;

import com.kkj.member.dao.MemberDao;
import com.kkj.member.dao.MemberDateDao;
import com.kkj.member.dto.ModalState;

/**
 * Servlet implementation class MemberDeleteAll
 */
public class MemberDeleteAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no=0;
		String strNo[] = request.getParameterValues("removecheck");
		
		String black = request.getParameter("delete");
		HttpSession session = request.getSession();
		MemberDao memberDao = new MemberDao();
		MemberDateDao memberDateDao =new MemberDateDao();
		if(black ==null || black.isEmpty()) {
			black="0";
		}
		if(strNo!=null && strNo.length>0) {
			for(int i=0;i<strNo.length;i++) {
				no = Integer.parseInt(strNo[i]);
				String userID = memberDao.idCheckDelete(no);
				String profile = memberDao.imageMember(no);
				String uplodaPath = "C:\\upload";
				int result = memberDao.deleteAdminMember(no);
				if(result>0) {
					File file = new File(uplodaPath+File.separator+profile);
					if(file.exists()) {
						file.delete();
					}
					memberDateDao.deleteDate(userID);
				}
			}
			ModalState modalState = new ModalState("show", "삭제되었습니다.");
			session.setAttribute("modalState", modalState);
			if(black.equals("black")) {
				response.sendRedirect("../member/blackList");	
			}else {	
				response.sendRedirect("../member/list");
			}
		}else {
			ModalState modalState = new ModalState("show", "선택해주세요.");
			session.setAttribute("modalState", modalState);
			if(black.equals("black")) {
				response.sendRedirect("../member/blackList");	
			}else {
				response.sendRedirect("../member/list");				
			}
		    
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
