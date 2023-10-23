package com.kkj.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.gson.Gson;
import com.kkj.member.util.RandomEmailCheck;
import com.kkj.member.util.SMTPAuthenticator;

/**
 * Servlet implementation class MemberSendEmail
 */
public class MemberSendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSendEmail() {
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
		int number =0;
		RandomEmailCheck check = new RandomEmailCheck();
		number = check.createRandomNum();
		HttpSession session = request.getSession();
		String to_email = request.getParameter("email"); //받는 이메일 주소
		System.out.println(to_email);
		String from_email ="kimhg1103@naver.com";
		String subject = "본인 인증을 위한 인증번호 메일입니다.";
		String content = "<h3>" + "요청하신 인증 번호" + "</h3> \r"+"<h2>"+number+"</h2> \r"
				+"해당 인증번호를 입력해주세요";
		
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
		    
		    Address toAddr = new InternetAddress(to_email);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람 
		    
		    msg.setContent(content, "text/html;charset=UTF-8"); // 내용과 인코딩
		    Transport.send(msg); // 전송
		    
		    HashMap<String, Integer> map = new HashMap();
		    map.put("checkNum", number);
		    Gson gson = new Gson();
		    String json = (String)gson.toJson(map);
		    request.setAttribute("json", json);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/numCheck.jsp");
		    dispatcher.forward(request, response);
		} catch(Exception e){
		    e.printStackTrace();
		    return;
		}
	}

}
