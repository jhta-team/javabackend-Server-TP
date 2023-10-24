package com.kkj.product.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.Collection;

import com.kkj.product.dao.ImageDao;
import com.kkj.product.dao.ProductDao;
import com.kkj.product.util.FileManager;
import com.kkj.product.util.ScriptWriter;

public class ProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pdtId = Integer.parseInt(request.getParameter("pdtId"));
		FileManager fileManager = new FileManager();
		fileManager.deleteImageFile(pdtId);
		fileManager.deleteThumFile(pdtId);
		ImageDao imgDao = new ImageDao();
		int resultImage = imgDao.deleteImg(pdtId);
		ProductDao pdtDao = new ProductDao();
		int resultProduct = pdtDao.deleteProduct(pdtId);
		
		if(resultProduct > 0 && resultImage > 0 ) {
			ScriptWriter.alertAndNext(response, "상품삭제 완료","../product/list");
		} else {
			ScriptWriter.alertAndBack(response, "삭제 오류");
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
