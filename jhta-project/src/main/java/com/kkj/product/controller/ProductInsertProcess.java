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
import java.util.Date;

import com.kkj.product.dao.ProductDao;
import com.kkj.product.dto.ProductDto;
import com.kkj.product.util.ScriptWriter;

public class ProductInsertProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductInsertProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//productinsert.jsp 에서 받아온 값 변수에 저장
		String pdtName = request.getParameter("pdtName");
		String pdtCty = request.getParameter("pdtCty");
		int pdtPrice = Integer.parseInt(request.getParameter("pdtPrice"));
		String pdtColor = request.getParameter("pdtColor");
		String pdtContent = request.getParameter("pdtContent");
		int pdtCount = Integer.parseInt(request.getParameter("pdtCount"));
		//Dto 객체 생성 후 각 변수에 값 할당
		ProductDto productDto = new ProductDto();
		productDto.setPdtName(pdtName);
		productDto.setPdtCty(pdtCty);
		productDto.setPdtPrice(pdtPrice);
		productDto.setPdtCount(pdtCount);
		productDto.setPdtColor(pdtColor);
		productDto.setPdtContent(pdtContent);
		
		//썸네일 관련 
		String uploadDirectory = "C:\\upload";
		String realUploadPath = uploadDirectory;		
		Part Thum = request.getPart("pdtThum");
		//System.out.println(Thum);
		String partHeader = Thum.getHeader("Content-disposition");
		//System.out.println(partHeader);
		String partArray[] = partHeader.split("filename=");
		String originalFileName = partArray[1].trim().replace("\"", "");
		String newFileName = "";		
		String folder = "";		
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		folder = simpleDateFormat.format(now);
		File dir = new File(realUploadPath+File.separator+folder);
		
		// 이미지 업로드 유무 체크
		if(!originalFileName.isEmpty()) {
			if(!dir.exists()) {
				dir.mkdir();
			}
			Thum.write(dir+File.separator+originalFileName);	// 서버에 파일 업로드
			
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

		String pdtThum = folder+"/"+newFileName;
		System.out.println(pdtThum);
		productDto.setPdtThum(pdtThum);
		//Dao 객체 생성 후 정의된 상품 등록 메서드 실행
		ProductDao productDao = new ProductDao();		
		int result = productDao.insertProduct(productDto);
		
		//결과값 처리
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "상품등록 완료","../product/list");
		} else {
			ScriptWriter.alertAndBack(response, "등록 오류");
		}
	}

}
