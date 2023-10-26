package com.kkj.product.controller;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.kkj.product.util.ScriptWriter;
import com.kkj.product.util.FileManager;

public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageUpload() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Collection<Part> parts = request.getParts();
		//파일 저장 관련 변수들
		String uploadDirectory = "C:\\upload";	
		String newFileName = ""; // 날짜정보 추가된 파일 이름 (yyyyMMddHHmmss+filename) 변수
		String folderName = ""; // 날짜정보 추가된 폴더 이름 (yyyyMMdd) 변수
		//날짜 관련
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd"); 
		folderName = simpleDateFormat.format(now);
		SimpleDateFormat simpleDateFormat02 = new SimpleDateFormat("yyyyMMddHHmmss");
		String strNow = simpleDateFormat02.format(now);
		File dir = new File(uploadDirectory+File.separator+folderName);
		
		//DB에 저장될 파일 이름 관련 변수들
		/*
		ArrayList<String> imgNameArray = new ArrayList<>(); //추가 이미지 파일 이름이 저장될 리스트
		String img1 = "";
		String img2 = "";
		String img3 = "";
		*/
		
		for(Part part : parts) {
			if(part.getName().startsWith("upload") && !part.getSubmittedFileName().isEmpty() ){ 
				//추가 이미지 
				//content-type 이 pdtImage이고 추가 이미지 파일이 있는 경우
				FileManager fileManager = new FileManager();
				newFileName = fileManager.changeFileName(part, dir, strNow);
				/*
				imgNameArray.add(newFileName);
				img1 = (imgNameArray.size()>=1) ? folderName+"/"+imgNameArray.get(0) : "null"; //추가 이미지 1개일 경우
				img2 = (imgNameArray.size()>=2) ? folderName+"/"+imgNameArray.get(1) : "null"; //추가 이미지 2개일 경우
				img3 = (imgNameArray.size()>=3) ? folderName+"/"+imgNameArray.get(2) : "null"; //추가 이미지 3개일 경우	
				fileManager.deleteImageFile(pdtId);
				*/
			}
		}
		
		
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<>();
		map.put("uploaded", true);
		map.put("url", request.getContextPath()+"/upload/"+folderName+"/"+newFileName);
		String resultJson = gson.toJson(map);
		request.setAttribute("resultJson", resultJson);
		System.out.println(resultJson);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/image-uploaded.jsp");
		dispatcher.forward(request, response);

	}

}
