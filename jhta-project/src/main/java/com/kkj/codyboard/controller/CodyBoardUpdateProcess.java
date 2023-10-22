package com.kkj.codyboard.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

import com.kkj.codyboard.dao.CodyBoardDao;
import com.kkj.codyboard.dto.CodyBoardUpdateDto;

/**
 * Servlet implementation class CodyBoardUpdateProcess
 */
public class CodyBoardUpdateProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodyBoardUpdateProcess() {
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
		CodyBoardUpdateDto codyBoardUpdateDto = new CodyBoardUpdateDto();
		CodyBoardImage codyBoadImage = new CodyBoardImage();
		
		int no = Integer.parseInt(request.getParameter("no"));
		String userID = request.getParameter("userID");
		String title = request.getParameter("codyBoardTitle");
		String content = request.getParameter("codyBoardContent");
		int categoryID = Integer.parseInt(request.getParameter("codyCategory"));
		String prevImage = request.getParameter("prevCodyImage");
		Part updateImagePart = request.getPart("codyImage");
		String updateImageHeader = updateImagePart.getHeader("Content-disposition");
		String updateImageArr[] = updateImageHeader.split("filename=");
		String checkImage = updateImageArr[1].trim().replace("\"", "");
		String realImage = prevImage; 
		if(!checkImage.isEmpty()) {
			String updateImage =  codyBoadImage.update(request, response, prevImage, userID, checkImage);
			realImage = updateImage;
		}
		 
		
		codyBoardUpdateDto.setNo(no);
		codyBoardUpdateDto.setTitle(title);
		codyBoardUpdateDto.setContent(content);
		codyBoardUpdateDto.setCategoryID(categoryID);
		codyBoardUpdateDto.setImages(realImage);
		
		
		CodyBoardDao codyBoardDao = new CodyBoardDao();
		int result = codyBoardDao.update(codyBoardUpdateDto);
		if(result > 0) {
			System.out.println("업데이트 성공!!");
		}else {
			System.out.println("업데이트 실패!!");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/codyboard/findone?no=" + request.getParameter("no"));
		dispatcher.forward(request, response);
	}

}
