package com.kkj.codyboard.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.kkj.cbcomment.dao.CbCommentDao;
import com.kkj.cbcomment.dto.CbCommentDto;
import com.kkj.cblike.dao.CbLikeDao;
import com.kkj.cbreply.dao.CbReplyDao;
import com.kkj.cbreply.dto.CbReplyDto;
import com.kkj.codyboard.dao.CodyBoardDao;
import com.kkj.codyboard.dto.CodyBoardDto;
import com.kkj.follow.dao.FollowDao;
import com.kkj.follow.dto.FollowDto;

/**
 * Servlet implementation class CodyBoardFindOne
 */
public class CodyBoardFindOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodyBoardFindOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CodyBoardDao codyBoardDao = new CodyBoardDao();
		CodyBoardDto codyBoardDto = new CodyBoardDto();
		CbCommentDao cbCommentDao = new CbCommentDao();
		CbReplyDao cbReplyDao = new CbReplyDao();
		CbLikeDao cbLikeDao = new CbLikeDao();
		CodyBoardHitCookie codyBoardHitCookie = new CodyBoardHitCookie();
		FollowDao followDao = new FollowDao();
		
		int codyBoardNo = Integer.parseInt(request.getParameter("no"));
		codyBoardDto = codyBoardDao.findOne(codyBoardNo);
		
		String userID = codyBoardDto.getUserID();
		System.out.println(userID);
		
		
		int likeCount = cbLikeDao.findCount(codyBoardNo);
		codyBoardHitCookie.hitCount(request, response, codyBoardNo);
		int follow = followDao.followCount(userID);
		int follower = followDao.followerCount(userID);
		List<CbCommentDto> cbCommentList = cbCommentDao.findAll(codyBoardNo);
		List<CbReplyDto> cbReplyList = cbReplyDao.find(codyBoardNo);
		request.setAttribute("codyBoard", codyBoardDto);
		request.setAttribute("cbComment", cbCommentList);
		request.setAttribute("reply", cbReplyList);
		request.setAttribute("likeCount", likeCount);
		request.setAttribute("follow",follow );
		request.setAttribute("follower", follower);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/codyboard/findone.jsp");
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
