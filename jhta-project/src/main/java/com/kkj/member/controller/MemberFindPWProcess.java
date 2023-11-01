package com.kkj.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.kkj.member.dao.MemberDao;
import com.kkj.member.util.RandomEmailCheck;
import com.kkj.member.util.SMTPAuthenticator;
import com.kkj.product.util.ScriptWriter;

/**
 * Servlet implementation class MemberFindPWProcess
 */
public class MemberFindPWProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindPWProcess() {
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
		String userID = request.getParameter("userID");
		String email =request.getParameter("email");
		String userName = request.getParameter("userName");
		RandomEmailCheck check = new RandomEmailCheck();
		String userPW = check.createPassWord();
		HashMap<String, String> map= new HashMap();
		map.put("userPW", userPW);
		map.put("userID", userID);
		map.put("email", email);
		map.put("userName", userName);
		MemberDao memberDao = new MemberDao();
		int result = memberDao.findPWChange(map);
		if(result>0) {
			String from_email ="kimhg1103@naver.com";
			String subject = "임시 비밀번호 메일입니다.";
			String content = "<h3>" + "요청하신 임시비밀번호는" + "</h3> \r"+"<h2>"+userPW+"</h2> \r"
					+"입니다.";
			
			Properties p = new Properties(); // 정보를 담을 객체
			p.put("mail.smtp.host","smtp.naver.com"); //smtp.naver.com 네이버 SMTP
			p.put("mail.smtp.port", "465");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.debug", "true");
			p.put("mail.smtp.socketFactory.port", "465"); //465
			p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			p.put("mail.smtp.socketFactory.fallback", "false");
			p.put("mail.smtp.ssl.protocols", "TLSv1.2");
			// SMTP 서버에 접속하기 위한 정보들
			
			try{
				
			    Authenticator auth = new SMTPAuthenticator();
			    Session ses = Session.getInstance(p, auth);     
			    ses.setDebug(true); 
			    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
			    msg.setSubject(subject); // 제목
			    
			    Address fromAddr = new InternetAddress(from_email);
			    msg.setFrom(fromAddr); // 보내는 사람 
			    
			    Address toAddr = new InternetAddress(email);
			    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람 
			    
			    msg.setContent(content, "text/html;charset=UTF-8"); // 내용과 인코딩
			    Transport.send(msg); // 전송
			    response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("console.log('"+userID+"');");
				out.println("</script>");
				ScriptWriter.alertAndNext(response, "이메일 전송되었습니다. 이메일을 확인해주세요", "../member/login");
			} catch(Exception e){
			    e.printStackTrace();
			    return;
		}
			
		}else {
			ScriptWriter.alertAndBack(response, "아이디와 이메일, 이름을 확인해주세요");
		}
		
	}

}
