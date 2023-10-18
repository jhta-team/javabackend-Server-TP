package com.kkj.codyboard.dao;

import java.util.HashMap;
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
		codyBoardList = sqlSession.selectList("findAllCodyBoard");
		return codyBoardList;
	}
	
	public int codyBoardCount() {
		int count = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		count = sqlSession.selectOne("codyBoardCount");
		return count;
	}
	
//	public List<CodyBoardDto> codyBoardPageNation(int page) {
//		int start = (page *10) +1;
//		int end = start + 9;
//		CodyBoardDto codyBoardDto = new CodyBoardDto();
//		HashMap <String,Object> pageMap = new HashMap<>();
//		pageMap.put("start", start);
//		pageMap.put("end", end);
//		
//		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
//		//codyBoardDto = sqlSession.selectList("codyBoardPageNation", pageMap);
//		return codyBoardDto;
//		
//		
//	}

}