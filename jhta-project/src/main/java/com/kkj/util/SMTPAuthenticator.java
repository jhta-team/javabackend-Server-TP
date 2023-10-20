package com.kkj.util;

import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;

public class SMTPAuthenticator extends Authenticator{
	protected PasswordAuthentication getPasswordAuthentication() {
		String mail_id = "kimhg1103@naver.com";
		String mail_pw = "gurrl101004";

		return new PasswordAuthentication(mail_id,mail_pw);
		//보내는 사람의 메일 아이디와 비밀번호
	}
}
