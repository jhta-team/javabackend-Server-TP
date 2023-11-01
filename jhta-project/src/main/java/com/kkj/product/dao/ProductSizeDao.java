package com.kkj.product.dao;


import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kkj.mybatis.MybatisConnectionFactory;
import com.kkj.product.dto.ProductSizeDto;

public class ProductSizeDao {
	public int insertProductSize(ProductSizeDto productSizeDto) { //상품등록에서 상품수량별 사이즈 insert 메서드
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("insertProductSize", productSizeDto);
		sqlSession.close();
		return result;
	}
	
	public ProductSizeDto selectProductSize(int pdtId) { // 상품상세보기에서 선택가능 사이즈 표시하기 위한 select 메서드
		ProductSizeDto productSizeDto = new ProductSizeDto();
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		productSizeDto = sqlSession.selectOne("selectProductSize", pdtId);
		sqlSession.close();
		return productSizeDto;
	}

	public int updateProductSize(ProductSizeDto productSizeDto) { // 상품수정에서 사이즈별 수량 수정을 위한 update 메서드
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateProductSize", productSizeDto);
		sqlSession.close();
		return result;
	}
}
