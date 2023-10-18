package com.kkj.codyboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kkj.codyboard.dto.CodyBoardDto;
import com.kkj.mybatis.MybatisConnectionFactory;

public class CodyBoardDao {

	public int insert(CodyBoardDto codyBoardDto) {
		// TODO Auto-generated method stub
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertCody", codyBoardDto);
		sqlSession.close();
		return result;
	}
	
	public List<CodyBoardDto> findAll() {
		List<CodyBoardDto> codyBoardList = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		codyBoardList = sqlSession.selectList("codyBoardFindAll");
		return codyBoardList;
	}

}
