package com.kkj.cart.dao;

import org.apache.ibatis.session.SqlSession;

import com.kkj.cart.dto.CartDto;
import com.kkj.mybatis.MybatisConnectionFactory;

public class CartDao {
	public int insertCart(CartDto cartDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("createCart",cartDto);
		sqlSession.close();
		return result;	
	}
	public CartDto findUserCart(String userId) {
		CartDto cartDto = new CartDto();
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		cartDto = sqlSession.selectOne("selectCart",userId);
		sqlSession.close();
		return cartDto;
	}
}
