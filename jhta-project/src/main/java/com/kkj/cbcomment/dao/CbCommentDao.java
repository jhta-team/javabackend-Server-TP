package com.kkj.cbcomment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kkj.cbcomment.dto.CbCommentDto;
import com.kkj.mybatis.MybatisConnectionFactory;

public class CbCommentDao {

	public int insert(CbCommentDto cbCommetDto) {
		// TODO Auto-generated method stub
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertCbComment", cbCommetDto);
		return result;
	}
	
	public List<CbCommentDto> findAll(int codyBoardNo) {
		List<CbCommentDto> cbCommentList = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		cbCommentList = sqlSession.selectList("findAllCbComment", codyBoardNo);
		System.out.println(cbCommentList);
		return cbCommentList;
	}
	
}
