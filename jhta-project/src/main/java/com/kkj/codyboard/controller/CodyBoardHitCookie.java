package com.kkj.codyboard.controller;

import java.util.Calendar;

import com.kkj.codyboard.dao.CodyBoardDao;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CodyBoardHitCookie
 */
public class CodyBoardHitCookie extends HttpServlet {
	public void hitCount(HttpServletRequest request, HttpServletResponse response, int codyBoardNo) {
		CodyBoardDao codyBoardDao = new CodyBoardDao();
		Cookie[] cookies = request.getCookies();
		Cookie prevCookie = null;
		String userID = "222";
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals(userID)) {
				prevCookie = cookie;
			}
		}
		Calendar now = Calendar.getInstance();
		Calendar finish = Calendar.getInstance();
		
		finish.add(Calendar.DATE, 1);
		finish.set(Calendar.HOUR_OF_DAY, 0);
		finish.set(Calendar.MINUTE, 0);
		finish.set(Calendar.SECOND, 0);
		long nowM = now.getTimeInMillis();
		long finishM = finish.getTimeInMillis();
		int cookieTime = (int)(finishM - nowM) / 1000;
		if(prevCookie != null) {
			if(!prevCookie.getValue().contains("[" + codyBoardNo + "]")) {
				prevCookie.setValue(prevCookie.getValue() + "[" + codyBoardNo + "]");
				prevCookie.setPath("/");
				prevCookie.setMaxAge(cookieTime);
				codyBoardDao.hit(codyBoardNo);
				response.addCookie(prevCookie);
			}
		}else {
			Cookie newCookie = new Cookie(userID, "[" + codyBoardNo + "]");
			newCookie.setPath("/");
			newCookie.setMaxAge(cookieTime);
			codyBoardDao.hit(codyBoardNo);
			response.addCookie(newCookie);
		}
		
	}

}
