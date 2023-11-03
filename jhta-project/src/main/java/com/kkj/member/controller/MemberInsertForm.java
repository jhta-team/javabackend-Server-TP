package com.kkj.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kkj.product.util.ScriptWriter;

/**
 * Servlet implementation class MemberInsertForm
 */
public class MemberInsertForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check0 = request.getParameter("check0");
		String check1 = request.getParameter("check1");
		if(check0==null) {
			check0="0";
		}
		if(check1==null) {
			check1="0";
		}
		if(check0.equals("1") && check1.equals("1") ) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/insert.jsp");
			dispatcher.forward(request, response);
		}else {
			ScriptWriter.alertAndBack(response, "모두 동의해주세요");
		}
	}

}
