package com.kkj.product.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kkj.mybatis.MybatisConnectionFactory;
import com.kkj.product.dto.ProductDto;

public class ProductDao {
	public List<ProductDto> listProduct(HashMap<String, Integer> map){
		List<ProductDto> listPdt = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		listPdt = sqlSession.selectList("listProduct",map);
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

	public ProductDto selectOneProduct(int pdtId) {
		ProductDto pdtDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		pdtDto = sqlSession.selectOne("selectOneProduct",pdtId);
		sqlSession.close();
		return pdtDto;
		// TODO Auto-generated method stub
		
	}

	public int updateProduct(ProductDto productDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateProduct",productDto);
		sqlSession.close();
		return result;
	}

	public int deleteProduct(int pdtId) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("deleteProduct",pdtId);
		sqlSession.close();
		return result;
		}

	public int countProduct() {
		int count = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		count = sqlSession.selectOne("countProduct");
		sqlSession.close();
		return count;
	}
}
