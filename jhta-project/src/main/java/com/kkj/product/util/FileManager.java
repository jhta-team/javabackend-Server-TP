package com.kkj.product.util;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import com.kkj.product.dao.ImageDao;
import com.kkj.product.dao.ProductDao;
import com.kkj.product.dto.ImageDto;
import com.kkj.product.dto.ProductDto;

import jakarta.servlet.http.Part;

public class FileManager {
	/* .getSubmittedFileName() 메서드로 대체
	public static String getFileName(Part part) {
		String realFileName = "";
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return realFileName;
    }
    */
	
	//파일 이름 변경 (image1.gif >> image1yyyyMMddHHmmss.gif) 메서드
	public String changeFileName(Part part, File dir, String strNow) { 
		String newFileName = ""; 
		String fileName = part.getSubmittedFileName();
		if(!dir.exists()) {
			dir.mkdir();
		}
		try {
			part.write(dir+File.separator+fileName);
			String subFileName = fileName.substring(0,fileName.lastIndexOf(".")); 
			String ext = fileName.substring(fileName.lastIndexOf(".")); 
			newFileName = subFileName+strNow+ext;
			File oldFile = new File(dir+File.separator+fileName);
			File newFile = new File(dir+File.separator+newFileName);
			oldFile.renameTo(newFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 				
		return newFileName;
	}
	public void deleteThumFile(int pdtId) {
		String uploadDirectory = "C:\\upload\\";
		ProductDao pdtDao = new ProductDao();
		ProductDto pdtDto = pdtDao.selectOneProduct(pdtId);
		File file = new File(uploadDirectory + pdtDto.getPdtThum());
		if(file.exists()) {file.delete();}	
	}
	
	public void deleteImageFile(int pdtId) {
		String uploadDirectory = "C:\\upload\\";		
		ImageDao imgDao = new ImageDao();
		ImageDto imgDto = imgDao.selectOneImg(pdtId);
		File file1  = new File(uploadDirectory + imgDto.getImg1());
		File file2  = new File(uploadDirectory + imgDto.getImg2());
		File file3  = new File(uploadDirectory + imgDto.getImg3());
		if(file1.exists()) {file1.delete();}
		if(file1.exists()) {file2.delete();}
		if(file1.exists()) {file3.delete();}		
	}

	
}
