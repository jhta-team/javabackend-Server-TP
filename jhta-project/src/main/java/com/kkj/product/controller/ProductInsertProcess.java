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
		//String realUploadPath = uploadDirectory;		
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
			System.out.println(part.getName());
			if(part.getName().startsWith("pdtImage")){ // 메인 이미지
				imageName = FileName.getFileName(part); // 이미지 파일 이름(확장자포함) 저장
				imgNameArray.add(imageName); // 상품 이미지 테이블 저장용 배열에 이미지 파일 이름 각각 저장
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
					//System.out.println(newFileName);
					//파일이름 변경(상품등록 날짜 추가)
					File oldFile = new File(dir+File.separator+imageName);
					File newFile = new File(dir+File.separator+newFileName);
					oldFile.renameTo(newFile);
				}
			} else if(part.getName().startsWith("pdtThum")) { //썸네일 
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
				
		
		//썸네일 관련 
		//Part Thum = request.getPart("pdtThum");
		
		//System.out.println(Thum);
		//String partHeader = Thum.getHeader("Content-disposition");
		//System.out.println(partHeader);
		//String partArray[] = partHeader.split("filename=");
		//String originalFileName = partArray[1].trim().replace("\"", "");		
		//String originalFileName = FileName.getFileName(Thum);
		
		
		// 썸네일 이미지 업로드 유무 체크
		/*
		if(!thumName.isEmpty()) {
			if(!dir.exists()) {
				dir.mkdir();
			}
			thum.write(dir+File.separator+originalFileName);	// 서버에 파일 작성
			
			String firstFileName = originalFileName.substring(0,originalFileName.lastIndexOf("."));
			String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
			SimpleDateFormat simpleDateFormat02 = new SimpleDateFormat("yyyyMMddHHmmss");
			String strNow = simpleDateFormat02.format(now);
			newFileName =  firstFileName+strNow+ext;
			//System.out.println(newFileName);
			//파일이름 변경(상품등록 날짜 추가)
			File oldFile = new File(dir+File.separator+originalFileName);
			File newFile = new File(dir+File.separator+newFileName);
			oldFile.renameTo(newFile);
		}
		
		// 이미지들 업로드 유무 체크
		if(!fileNameArray.isEmpty()) {
			if(!dir.exists()) {
				dir.mkdir();
			}
			imgs.write(dir+File.separator+originalFileName);	// 서버에 파일 작성
			
			String firstFileName = originalFileName.substring(0,originalFileName.lastIndexOf("."));
			String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
			SimpleDateFormat simpleDateFormat02 = new SimpleDateFormat("yyyyMMddHHmmss");
			String strNow = simpleDateFormat02.format(now);
			newFileName =  firstFileName+strNow+ext;
			//System.out.println(newFileName);
			//파일이름 변경(상품등록 날짜 추가)
			File oldFile = new File(dir+File.separator+originalFileName);
			File newFile = new File(dir+File.separator+newFileName);
			oldFile.renameTo(newFile);
		}		
		*/
		String pdtThum = folderName+"/"+newFileName; // 상품 테이블에 pdtthum 컬럼에 저장되는 값(이미지 주소)
		//System.out.println(pdtThum);
		

		//Dto 객체 생성 후 각 변수에 값 할당
		ProductDto productDto = new ProductDto();
		productDto.setPdtName(pdtName);
		productDto.setPdtCty(pdtCty);
		productDto.setPdtPrice(pdtPrice);
		productDto.setPdtCount(pdtCount);
		productDto.setPdtColor(pdtColor);
		productDto.setPdtContent(pdtContent);
		productDto.setPdtThum(pdtThum);
		
		ImageDto imageDto = new ImageDto();
		imageDto.getPdtId(pdt)


		//System.out.println(imgs);
		//String imgsHeader = imgs.getHeader("Content-disposition");
		//System.out.println(imgsHeader);
		//String partArray[] = partHeader.split("filename=");
		//String originalFileName = partArray[1].trim().replace("\"", "");
		//String newFileName = "";		
		//String folder = "";		
		//Date now = new Date();
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		//folder = simpleDateFormat.format(now);
		//File dir = new File(realUploadPath+File.separator+folder);
		
		
		//Dao 객체 생성 후 정의된 상품 등록 메서드 실행
		ProductDao productDao = new ProductDao();
		int result = productDao.insertProduct(productDto);
		ImageDao imageDao = new ImageDao();
		
		//결과값 처리
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "상품등록 완료","../product/list");
		} else {
			ScriptWriter.alertAndBack(response, "등록 오류");
		}

	}

}
