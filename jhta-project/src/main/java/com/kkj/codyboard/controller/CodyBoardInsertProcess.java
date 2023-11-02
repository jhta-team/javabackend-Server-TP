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
		System.out.println("여기??드러옴???");
		String codyTitle = request.getParameter("codyBoardTitle");
//		int codyCategory = Integer.parseInt(request.getParameter("codyCategory"));
		String codyContent = request.getParameter("codyBoardContent");
		CodyBoardImage codyBoardImage = new CodyBoardImage();
//		Part part = request.getPart("codyImage");
//		System.out.println(part);
		Part codyImage = request.getPart("codyImage");
		System.out.println("여기뭐들어옴??=====>???? " + codyImage);
//		String codyImageHeader = codyImage.getHeader("Content-disposition");
//		String codyImageArray[] = codyImageHeader.split("filename=");
//		
		String mok = request.getParameter("mok");
		System.out.println("?? ===>> " + mok);
		
		System.out.println(codyTitle);
		System.out.println(request.getParameter("codyCategory"));
		System.out.println(codyContent);
		
//		String uploadCodyImage = codyImageArray[1].trim().replace("\"", "");
//		String newCodyImage = codyBoardImage.upload(request,response, uploadCodyImage);
//		
//		System.out.println(codyImageHeader);
//		System.out.println(codyImageArray[1]);
		

		

		CodyBoardDto codyBoardDto = new CodyBoardDto();
		CodyBoardDao codyBoardDao = new CodyBoardDao();
		codyBoardDto.setTitle(codyTitle);
//		codyBoardDto.setCategoryID(codyCategory);
//		codyBoardDto.setContent(codyContent);
		//codyBoardDto.setImages(newCodyImage);
		codyBoardDto.setUserID("mok119");
		
	
//		int result = codyBoardDao.insert(codyBoardDto);
//		if(result > 0) {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/codyboard/pagenation.jsp");
//			dispatcher.forward(request, response);
//			
//			System.out.println("성공하였습니다.");
//		}else {
//			System.out.println("실패하였습니다.");
//		}
		

		
		
	}

}
