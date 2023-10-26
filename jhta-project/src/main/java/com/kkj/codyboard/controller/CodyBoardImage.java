package com.kkj.codyboard.controller;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class CodyBoardImage {
	public String upload(HttpServletRequest request, HttpServletResponse response, String uploadImage) {
		String newCodyImage = "";
		try {
			Part codyImage = request.getPart("codyImage");
			if(!uploadImage.isEmpty()) {
				String userID = "mok119";
				String uploadDirectory = "/Users/junghunmok/upload";
				String firstFileName = uploadImage.substring(0, uploadImage.lastIndexOf("."));
				String ext = uploadImage.substring(uploadImage.lastIndexOf("."));
				newCodyImage = userID + ext;
				codyImage.write(uploadDirectory + File.separator + newCodyImage); 
			}
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newCodyImage;
	}
	
	
	
	
	public String update(HttpServletRequest request, HttpServletResponse response, String prevImage, String userID, String checkImage) throws IOException {
		String saveUpdateImage ="";
		try {
			Part updateImagePart = request.getPart("codyImage");
			String imageType = checkImage.substring(checkImage.lastIndexOf("."));
			if(!checkImage.isEmpty()) {
				String uploadDirectory = "/Users/junghunmok/upload";
				saveUpdateImage = userID+ "_1" + imageType;
				File oldImage = new File(uploadDirectory + File.separator + prevImage);
				
				oldImage.delete();
				updateImagePart.write(uploadDirectory + File.separator + saveUpdateImage);
				
			}
			
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
		return saveUpdateImage;
	}
	
	public boolean delete(HttpServletRequest request, HttpServletResponse response) {
		String image = request.getParameter("image");
		String uploadDirectory = "/Users/junghunmok/upload";
		File myImage = new File(uploadDirectory + File.separator + image);
		return myImage.delete();
	}
}
