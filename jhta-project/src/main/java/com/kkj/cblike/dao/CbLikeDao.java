package com.kkj.cblike.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kkj.cblike.dto.CbLikeDto;
import com.kkj.mybatis.MybatisConnectionFactory;

public class CbLikeDao {

	public int insetLike(CbLikeDto cbLikeDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertCbLike", cbLikeDto);
//		List<CbLikeDto> cbList = sqlSession.selectList("findAllLike");
//		System.out.println(cbList);
		return result;
	}

	public int findOne(CbLikeDto cbLikeDto) {
		CbLikeDto cbLikeDto1 = new CbLikeDto();
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		cbLikeDto1 = sqlSession.selectOne("findOneLike", cbLikeDto);
		int result = 0;
		if(cbLikeDto1 == null) {
			result = 1;
		}
		return result;
	}

	public int delete(CbLikeDto cbLikeDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteLike", cbLikeDto);
		return result;
	}
	
	public int findCount(int cbNo) {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		int count = sqlSession.selectOne("findCount", cbNo);
		System.out.println(count);
		return count;
	}

}
