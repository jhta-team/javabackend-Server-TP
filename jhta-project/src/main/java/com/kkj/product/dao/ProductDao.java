package com.kkj.product.dao;

import java.util.ArrayList;
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
	

}
