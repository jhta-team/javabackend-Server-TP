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
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kkj.codyboard.dao.CodyBoardDao;
import com.kkj.codyboard.dto.CodyBoardDto;

/**
 * Servlet implementation class CodyBoardInsertProcess
 */
public class CodyBoardInsertProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodyBoardInsertProcess() {
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
		String codyTitle = request.getParameter("codyBoardTitle");
		int codyCategory = Integer.parseInt(request.getParameter("codyCategory"));
		String codyContent = request.getParameter("codyBoardContent");
		
		CodyBoardImage codyBoardImage = new CodyBoardImage();
		Part codyImage = request.getPart("codyImage");
		String codyImageHeader = codyImage.getHeader("Content-disposition");
		String codyImageArray[] = codyImageHeader.split("filename=");
		

		
		String uploadCodyImage = codyImageArray[1].trim().replace("\"", "");
		System.out.println("=======>>>>>"+uploadCodyImage);
		String newCodyImage = codyBoardImage.upload(request,response, uploadCodyImage);
		
		System.out.println(codyImageHeader);
		System.out.println(codyImageArray[1]);
		
		System.out.println(codyTitle);
		System.out.println(codyCategory);
		System.out.println(codyContent);
		

		CodyBoardDto codyBoardDto = new CodyBoardDto();
		CodyBoardDao codyBoardDao = new CodyBoardDao();
		codyBoardDto.setTitle(codyTitle);
		codyBoardDto.setCategoryID(codyCategory);
		codyBoardDto.setContent(codyContent);
		codyBoardDto.setImages(newCodyImage);
		codyBoardDto.setUserID("mok1119");
		
	
		int result = codyBoardDao.insert(codyBoardDto);
		if(result > 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../codyboard/page-nation");
			dispatcher.forward(request, response);
			
			System.out.println("성공하였습니다.");
		}else {
			System.out.println("실패하였습니다.");
		}
		PrintWriter out = new PrintWriter(System.out);	

		
		
	}

}
