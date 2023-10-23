package com.kkj.product.controller;

import jakarta.servlet.ServletException;
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
import java.util.List;

import com.kkj.product.dao.ImageDao;
import com.kkj.product.dao.ProductDao;
import com.kkj.product.dto.ImageDto;
import com.kkj.product.dto.ProductDto;
import com.kkj.product.util.FileName;
import com.kkj.product.util.ScriptWriter;

public class ProductInsertProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductInsertProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상품등록에서 받아온 값 변수에 저장
		String pdtName = request.getParameter("pdtName");
		String pdtCty = request.getParameter("pdtCty");
		int pdtPrice = Integer.parseInt(request.getParameter("pdtPrice"));
		String pdtColor = request.getParameter("pdtColor");
		String pdtContent = request.getParameter("pdtContent");
		int pdtCount = Integer.parseInt(request.getParameter("pdtCount"));
		
		//파일 저장 관련 변수들
		String uploadDirectory = "C:\\upload";	
		String newFileName = "";		
		String folderName = "";
		String imageName = "";
		String thumName = "";
		//날짜 관련
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		folderName = simpleDateFormat.format(now);
		File dir = new File(uploadDirectory+File.separator+folderName);

		
		
		//request 헤더값에서 이미지들 받아와서 저장 하는 코드 	
		Collection<Part> imgs = request.getParts();
		ArrayList<String> imgNameArray = new ArrayList<>();

		for(Part part : imgs) {
			//System.out.println(part.getName());
			if(part.getName().startsWith("pdtImage") && !part.getSubmittedFileName().isEmpty()){ // 메인 이미지
				imageName = FileName.getFileName(part); // 이미지 파일 이름(확장자포함) 저장
				
				if(imageName != null && !imageName.isEmpty()) {
					if(!dir.exists()) {
						dir.mkdir();
					}
					part.write(dir+File.separator+imageName); // 서버에 파일 작성					
					String FileName = imageName.substring(0,imageName.lastIndexOf("."));
					String ext = imageName.substring(imageName.lastIndexOf("."));
					SimpleDateFormat simpleDateFormat02 = new SimpleDateFormat("yyyyMMddHHmmss");
					String strNow = simpleDateFormat02.format(now);
					newFileName =  FileName+strNow+ext;
					imgNameArray.add(newFileName); // 상품 이미지 테이블 저장용 배열에 이미지 파일 이름 각각 저장
					//System.out.println(newFileName);
					//파일이름 변경(상품등록 날짜 추가)
					File oldFile = new File(dir+File.separator+imageName);
					File newFile = new File(dir+File.separator+newFileName);
					oldFile.renameTo(newFile);
				}
			} else if(part.getName().startsWith("pdtThum") && !part.getSubmittedFileName().isEmpty()) { //썸네일 
				thumName = FileName.getFileName(part); // 썸네일 이미지 파일 이름(확장자 포함)
				if(thumName != null && !thumName.isEmpty()) {
					if(!dir.exists()) {
						dir.mkdir();
					}
					part.write(dir+File.separator+thumName); // 서버에 파일 작성					
					String FileName = thumName.substring(0,thumName.lastIndexOf("."));
					String ext = thumName.substring(thumName.lastIndexOf("."));
					SimpleDateFormat simpleDateFormat02 = new SimpleDateFormat("yyyyMMddHHmmss");
					String strNow = simpleDateFormat02.format(now);
					newFileName =  FileName+strNow+ext;
					//System.out.println(newFileName);
					//파일이름 변경(상품등록 날짜 추가)
					File oldFile = new File(dir+File.separator+thumName);
					File newFile = new File(dir+File.separator+newFileName);
					oldFile.renameTo(newFile);
				}
			}
		}
				

		String pdtThum = folderName+"/"+newFileName; // 상품 테이블에 pdtthum 컬럼에 저장되는 값(이미지 주소)
		String img1 = (imgNameArray.size()>=1) ? imgNameArray.get(0) : "null";
		System.out.println(img1);
		String img2 = (imgNameArray.size()>=2) ? imgNameArray.get(1) : "null";
		System.out.println(img2);
		String img3 = (imgNameArray.size()>=3) ? imgNameArray.get(2) : "null";
		System.out.println(img3);
		ProductDto productDto = new ProductDto();
		ProductDao productDao = new ProductDao();
		productDto.setPdtName(pdtName);
		productDto.setPdtCty(pdtCty);
		productDto.setPdtPrice(pdtPrice);
		productDto.setPdtCount(pdtCount);
		productDto.setPdtColor(pdtColor);
		productDto.setPdtContent(pdtContent);
		productDto.setPdtThum(pdtThum);		
		int resultProduct = productDao.insertProduct(productDto);
		
		ImageDao imageDao = new ImageDao();
		ImageDto imageDto = new ImageDto();
		imageDto.setImg1(img1);
		imageDto.setImg2(img2);
		imageDto.setImg3(img3);
		int resultImage = imageDao.insertImg(imageDto);
		
		//결과값 처리

		if(resultProduct > 0) {
			if(resultImage > 0) {
				ScriptWriter.alertAndNext(response, "상품등록 완료","../product/list");
			}
			ScriptWriter.alertAndBack(response, "이미지 등록 오류");
		} else {
			ScriptWriter.alertAndBack(response, "등록 오류");
		}


	}

}
