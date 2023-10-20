package com.kkj.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kkj.member.dao.MemberDao;
import com.kkj.member.dto.MemberDto;

/**
 * Servlet implementation class MemberInsertProcess
 */
public class MemberInsertProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertProcess() {
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
		MemberDto memberInsert = new MemberDto();
		MemberDao memberDao = new MemberDao();
		int result =0;
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		String strGender = request.getParameter("gender");
		int gender=0;
		if(strGender!=null && !strGender.isEmpty()) {
			gender=Integer.parseInt(strGender);
		}
		String strPostCode = request.getParameter("postCode");
		int postCode = 0;
		if(strPostCode!=null && !strPostCode.isEmpty()) {
			postCode= Integer.parseInt(strPostCode);
		}
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		String email = request.getParameter("email");
		String mobileTelcom = request.getParameter("mobileTelcom");
		String tel = request.getParameter("tel");
		String nickName = request.getParameter("nickName");
		String strNo = request.getParameter("no");
		int no =0;
		if(strNo!=null && !strNo.isEmpty()) {
			no= Integer.parseInt(strNo);
		}
		Part profile = request.getPart("profile");
		
		String uploadPath = "C:\\upload";
		String partHeader = profile.getHeader("Content-disposition");
		String fileArray[] = partHeader.split("filename=");
		String fileName = fileArray[1].trim().replace("\"", "");
		String newFileName ="";
		if(!fileName.isEmpty()) {
			profile.write(uploadPath+File.separator+fileName);
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String firstFileName = fileName.substring(0, fileName.lastIndexOf("."));
			Date now = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-hhmmss");
			String strNow = simpleDateFormat.format(now);
			newFileName = firstFileName+strNow+ext;
			File oldFile = new File(uploadPath+File.separator+fileName);
			File newFile = new File(uploadPath+File.separator+newFileName);
			oldFile.renameTo(newFile);
		}
		memberInsert.setUserID(userID);
		memberInsert.setUserPW(userPW);
		memberInsert.setUserName(userName);
		memberInsert.setGender(gender);
		memberInsert.setAddress(address);
		memberInsert.setDetailAddress(detailAddress);
		memberInsert.setPostCode(postCode);
		memberInsert.setEmail(email);
		memberInsert.setMobileTelcom(mobileTelcom);
		memberInsert.setTel(tel);
		memberInsert.setProfile(newFileName);
		memberInsert.setNickName(nickName);
		memberInsert.setNo(no);
		
		result=memberDao.insertMember(memberInsert);
		if(result>0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}