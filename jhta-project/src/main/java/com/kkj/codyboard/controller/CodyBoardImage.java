package com.kkj.codyboard.controller;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class CodyBoardImage {
	public String update(HttpServletRequest request, HttpServletResponse response, String prevImage, String userID) throws IOException {
		System.out.println("여기는다른 서블릿안입니다.!!!");
		Part updateImagePart;
		String saveUpdateImage ="";
		try {
			updateImagePart = request.getPart("codyImage");
			
			String updateImageHeader = updateImagePart.getHeader("Content-disposition");
			String updateImageArr[] = updateImageHeader.split("filename=");
			String checkImage = updateImageArr[1].trim().replace("\"", "");
			
			if(!checkImage.isEmpty()) {
				String uploadDirectory = "/Users/junghunmok/upload";
				saveUpdateImage = userID+ "_1";
				System.out.println("저장될 이미지 이름=>>>" + saveUpdateImage);
				File oldImage = new File(uploadDirectory + File.separator + prevImage);
				
				oldImage.delete();
				updateImagePart.write(uploadDirectory + File.separator + saveUpdateImage);
				
			}
			
			System.out.println("여기는다른 서블릿안입니다.!!!");
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saveUpdateImage;
		
		
	}
}
