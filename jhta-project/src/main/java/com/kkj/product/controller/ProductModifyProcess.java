package com.kkj.product.controller;

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

import com.kkj.product.dao.ImageDao;
import com.kkj.product.dao.ProductDao;
import com.kkj.product.dto.ImageDto;
import com.kkj.product.dto.ProductDto;
import com.kkj.product.util.FileManager;
import com.kkj.product.util.ScriptWriter;

public class ProductModifyProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductModifyProcess() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 상품수정에서 받아온 값 변수에 저장
		int pdtId = Integer.parseInt(request.getParameter("pdtId"));
		String pdtName = request.getParameter("pdtName");
		String pdtCty = request.getParameter("pdtCty");
		String strPrice = request.getParameter("pdtPrice");
		int pdtPrice = Integer.parseInt(strPrice.replaceFirst("^0+(?!$)", ""));
		String pdtColor = request.getParameter("pdtColor");
		String pdtContent = request.getParameter("pdtContent");
		String strCount = request.getParameter("pdtPrice");
		int pdtCount = Integer.parseInt(strCount.replaceFirst("^0+(?!$)", ""));
		Collection<Part> parts = request.getParts();
		String strState = request.getParameter("pdtState");
		int pdtState = Integer.parseInt(strState);
		if (pdtCount == 0) {
			pdtState = 0;
		}

		// 파일 저장 관련 변수들
		String uploadDirectory = "C:\\upload";
		String newFileName = ""; // 날짜정보 추가된 파일 이름 (yyyyMMddHHmmss+filename) 변수
		String folderName = ""; // 날짜정보 추가된 폴더 이름 (yyyyMMdd) 변수
		// 날짜 관련
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		folderName = simpleDateFormat.format(now);
		SimpleDateFormat simpleDateFormat02 = new SimpleDateFormat("yyyyMMddHHmmss");
		String strNow = simpleDateFormat02.format(now);
		File dir = new File(uploadDirectory + File.separator + folderName);

		// DB에 저장될 파일 이름 관련 변수들
		ArrayList<String> imgNameArray = new ArrayList<>(); // 추가 이미지 파일 이름이 저장될 리스트
		String pdtThum = "";
		String img1 = "";
		String img2 = "";
		String img3 = "";

		ImageDao imageDao = new ImageDao();
		ImageDto imageDto = new ImageDto();
		int resultImage = 0;
		int partIndex = 1;
		for (Part part : parts) {
			if (part.getName().startsWith("pdtImage") && part.getSubmittedFileName().isEmpty()) {
				//상품 이미지 수정 안할경우
				continue;
				
			} else if (part.getName().startsWith("pdtImage") && !part.getSubmittedFileName().isEmpty()) {
				// 추가 이미지
				// content-type 이 pdtImage이고 추가 이미지 파일이 있는 경우
				FileManager fileManager = new FileManager();
				System.out.println(partIndex);
				fileManager.deleteImageFile(pdtId, partIndex);				
				partIndex++;
				
				newFileName = fileManager.changeFileName(part, dir, strNow);
				imgNameArray.add(newFileName);
				img1 = (imgNameArray.size() >= 1) ? folderName + "/" + imgNameArray.get(0) : "null"; // 추가 이미지 1개일 경우
				img2 = (imgNameArray.size() >= 2) ? folderName + "/" + imgNameArray.get(1) : "null"; // 추가 이미지 2개일 경우
				img3 = (imgNameArray.size() >= 3) ? folderName + "/" + imgNameArray.get(2) : "null"; // 추가 이미지 3개일 경우
				
			} else if (part.getName().startsWith("pdtThum") && !part.getSubmittedFileName().isEmpty()) {
				// 썸네일
				// content-type 이 pdtThum이고 썸네일을 업로드 했다면
				FileManager fileManager = new FileManager();
				fileManager.deleteThumFile(pdtId);
				pdtThum = folderName + "/" + fileManager.changeFileName(part, dir, strNow);
			}
		}
		imageDto.setPdtId(pdtId);
		imageDto.setImg1(img1);
		imageDto.setImg2(img2);
		imageDto.setImg3(img3);
		resultImage = imageDao.updateImg(imageDto);
		
		//상품테이블 관련
		ProductDto productDto = new ProductDto();
		ProductDao productDao = new ProductDao();
		productDto.setPdtId(pdtId);
		productDto.setPdtName(pdtName);
		productDto.setPdtCty(pdtCty);
		productDto.setPdtPrice(pdtPrice);
		productDto.setPdtCount(pdtCount);
		productDto.setPdtColor(pdtColor);
		productDto.setPdtContent(pdtContent);
		productDto.setPdtThum(pdtThum);
		productDto.setPdtState(pdtState);
		int resultProduct = productDao.updateProduct(productDto);


		// 결과값 처리

		if (resultProduct > 0) {
			ScriptWriter.alertAndNext(response, "상품수정 완료", "../product/list");
		} else {
			ScriptWriter.alertAndBack(response, "수정 오류");
		}
	}
}
