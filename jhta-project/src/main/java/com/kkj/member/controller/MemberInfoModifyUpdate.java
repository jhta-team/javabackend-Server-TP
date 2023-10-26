package com.kkj.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kkj.member.dao.MemberDao;
import com.kkj.member.dto.MemberDto;
import com.kkj.member.dto.ModalState;
import com.kkj.product.util.ScriptWriter;

/**
 * Servlet implementation class MemberInfoModifyUpdate
 */
public class MemberInfoModifyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInfoModifyUpdate() {
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
		MemberDao memberDao = new MemberDao();
		MemberDto updateMember = new MemberDto();
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("loggedID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String strPostCode = request.getParameter("postCode");
		int postCode =0;
		if(strPostCode!=null && !strPostCode.isEmpty()) {
			postCode = Integer.parseInt(strPostCode);
		}
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		String email = request.getParameter("email");
		String mobileTelcom = request.getParameter("mobileTelcom");
		String tel01 = request.getParameter("tel01");
		String tel02 = request.getParameter("tel02");
		String tel03 = request.getParameter("tel03");
		String tel = tel01+"-"+tel02+"-"+tel03;
		Part profile = request.getPart("profile");
		
		String uploadPath = "C:\\upload";
		
		MemberDto loggedMember =(MemberDto)session.getAttribute("loggedMember");
		String preProfile = loggedMember.getProfile();
		File file = new File(uploadPath+File.separator+preProfile);
		
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
		
		updateMember.setUserID(userID);
		updateMember.setUserPW(userPW);
		updateMember.setUserName(userName);
		updateMember.setNickName(nickName);
		updateMember.setPostCode(postCode);
		updateMember.setAddress(address);
		updateMember.setDetailAddress(detailAddress);
		updateMember.setEmail(email);
		updateMember.setTel(tel);
		updateMember.setMobileTelcom(mobileTelcom);
		updateMember.setProfile(newFileName);
		if(fileName.isEmpty()) {  //이미지 변경 없으면 이전 파일 그대로 사용하기위해
			if(preProfile!=null) {
				updateMember.setProfile(preProfile);				
			}
		}
		int result = memberDao.infoUpdateMember(updateMember);
		if(result>0) {
			String modalCheck = "1";
			
			session.setAttribute("loggedName", userName);
			session.setAttribute("loggedMember",updateMember );
			if(file.exists()) {	
				if(!fileName.isEmpty()) { //이미지 변경하면 기존 파일 제거
					file.delete();										
				}
			}
			response.sendRedirect("../member/info");
		}else {
			ScriptWriter.alertAndBack(response, "서버오류입니다.");
		}
	}

}
