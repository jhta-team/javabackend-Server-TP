package com.kkj.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kkj.mybatis.MybatisConnectionFactory;
import com.kkj.product.dto.ProductDto;

public class ProductDao {
	public List<ProductDto> listProduct(){
		List<ProductDto> listPdt = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		listPdt = sqlSession.selectList("listProduct");
		sqlSession.close();
		return listPdt;
	}
	
	public int insertProduct(ProductDto productDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("insertProduct",productDto);
		sqlSession.close();
		return result;
	}
	
	public ProductDto detailProduct(int pdtId) {
		ProductDto detailDto = new ProductDto();
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		detailDto = sqlSession.selectOne("detailProduct",pdtId);
		sqlSession.close();
		return detailDto;
	}
}
