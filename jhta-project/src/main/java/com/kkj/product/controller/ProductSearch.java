package com.kkj.product.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kkj.product.dao.ProductDao;
import com.kkj.product.dto.ProductDto;
import com.kkj.product.util.ScriptWriter;

@WebServlet("/product/search")
public class ProductSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductSearch() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String category = request.getParameter("category");
		String keyword = request.getParameter("keyword");
		int intKeyWord = 0;
		Map<String, Object> map = new HashMap<>();
		if (category.equals("pdtPrice")) {
			try {
					intKeyWord = Integer.parseInt(keyword);
					map.put("keyword", intKeyWord);
					map.put("category", category);
			} catch(NumberFormatException e) { 
					e.printStackTrace();
					ScriptWriter.alertAndBack(response, "숫자만 입력하세요");
			}
		} else {
			map.put("keyword", keyword);
			map.put("category", category);
		}
		ProductDao searchDao = new ProductDao();

		// ProductDao pdtDao = new ProductDao();

		String strPage = request.getParameter("page");
		int totalCount = searchDao.searchProductCount(map);
		int intpage = 0;
		int lastpage = 10;
		int totalpage = (int) Math.ceil(totalCount / (double) lastpage);
		if (strPage == null || strPage.isEmpty()) {
			intpage = 1;
		} else {
			intpage = Integer.parseInt(strPage);
		}
		if (totalpage < intpage) {
			intpage = totalpage;
		}
		int startpage = ((intpage - 1) / lastpage) * lastpage + 1;
		int endpage = startpage + lastpage - 1;
		if (endpage > totalpage) {
			endpage = totalpage;
		}
		map.put("start", (intpage - 1) * 9 + 1);
		map.put("end", intpage * 9);

		List<ProductDto> searchDto = searchDao.searchProduct(map);

		if (searchDto.size() != 0) {
			request.setAttribute("ProductList", searchDto);
			request.setAttribute("intpage", intpage);
			request.setAttribute("startpage", startpage);
			request.setAttribute("endpage", endpage);
			request.setAttribute("totalCount", totalCount);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/productlist.jsp");
			dispatcher.forward(request, response);
		} else {
			ScriptWriter.alertAndBack(response, "조회 결과가 없습니다");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
