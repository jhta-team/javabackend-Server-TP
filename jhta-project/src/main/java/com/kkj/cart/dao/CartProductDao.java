package com.kkj.cart.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kkj.cart.dto.CartProductDto;
import com.kkj.mybatis.MybatisConnectionFactory;

public class CartProductDao {

	public int insertCart(CartProductDto cartProductDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("insertCart",cartProductDto);
		sqlSession.close();
		return result;		
	}

	public List<CartProductDto> selectListCart() {
		List<CartProductDto> cartProductDto = new ArrayList<>();
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		cartProductDto = sqlSession.selectList("selectListCart");
		sqlSession.close();
		return cartProductDto;		
	}
	
	/*
	public String selectThumCart(int pdtId) {
		String strThum = "null";		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		strThum = sqlSession.selectOne("selectThumCart",pdtId);
		sqlSession.close();
		return strThum;		
	}
	*/
	
	public int deleteCart(int cartItemId) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("deleteCart",cartItemId);
		sqlSession.close();
		return result;
	}

	public int updateCart(CartProductDto cartProductDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateCart",cartProductDto);
		sqlSession.close();
		return result;
	}


}
