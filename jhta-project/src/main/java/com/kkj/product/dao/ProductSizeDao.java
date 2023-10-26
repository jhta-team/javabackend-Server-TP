package com.kkj.product.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kkj.mybatis.MybatisConnectionFactory;
import com.kkj.product.dto.ProductDto;
import com.kkj.product.dto.ProductSizeDto;

public class ProductSizeDao {
	public int insertProductSize(ProductSizeDto productSizeDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("insertProductSize", productSizeDto);
		sqlSession.close();
		return result;
	}

	public ProductSizeDto selectProductSize(int pdtId) {
		ProductSizeDto productSizeDto = new ProductSizeDto();
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		productSizeDto = sqlSession.selectOne("selectProductCount", pdtId);
		sqlSession.close();
		return productSizeDto;
	}

}
