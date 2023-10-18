package com.kkj.codyboard.controller;

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
		String codyTitle = request.getParameter("codyBoardTitle");
		int codyCategory = Integer.parseInt(request.getParameter("codyCategory"));
		String codyContent = request.getParameter("codyBoardContent");
		
		String uploadDirectory = "/Users/junghunmok/Desktop/upload";
		String realUploadPath = uploadDirectory;
		
		Part codyImage = request.getPart("codyImage");
		String codyImageHeader = codyImage.getHeader("Content-disposition");
		String codyImageArray[] = codyImageHeader.split("filename=");
		String prevCodyImage = codyImageArray[1].trim().replace("\"", "");
		String newCodyImage = "";
		
		

		if(!prevCodyImage.isEmpty()) {
			String userID = "mok119";
			String firstFileName = prevCodyImage.substring(0, prevCodyImage.lastIndexOf("."));
			String ext = prevCodyImage.substring(prevCodyImage.lastIndexOf("."));
			System.out.println("firstFileName =>>>>>>" + firstFileName);
			System.out.println("ext =>>>>" + ext);
			newCodyImage = firstFileName + userID + ext;
			System.out.println(newCodyImage);

			codyImage.write(realUploadPath + File.separator + newCodyImage); 
		}
		

		CodyBoardDto codyBoardDto = new CodyBoardDto();
		CodyBoardDao codyBoardDao = new CodyBoardDao();
		codyBoardDto.setTitle(codyTitle);
		codyBoardDto.setCategoryID(codyCategory);
		codyBoardDto.setContent(codyContent);
		codyBoardDto.setImages(newCodyImage);
		
	
		int result = codyBoardDao.insert(codyBoardDto);
		if(result > 0) {
			System.out.println("성공하였습니다.");
		}else {
			System.out.println("실패하였습니다.");
		}
		

		
		
	}

}
