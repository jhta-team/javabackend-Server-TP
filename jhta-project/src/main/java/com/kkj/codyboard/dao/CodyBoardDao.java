package com.kkj.codyboard.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kkj.codyboard.dto.CodyBoardDto;
import com.kkj.codyboard.dto.CodyBoardUpdateDto;
import com.kkj.codyboard.dto.PageNationDto;
import com.kkj.mybatis.MybatisConnectionFactory;

import jakarta.el.ELException;

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
	
	public CodyBoardDto findOne(int codyBoardNo) {
		CodyBoardDto codyBoardDto = new CodyBoardDto();
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		codyBoardDto = sqlSession.selectOne("codyBoardFindOne", codyBoardNo);
		return codyBoardDto;
		
	}
	
	public int codyBoardCount() {
		int count = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		count = sqlSession.selectOne("codyBoardCount");
		return count;
	}
	
	public List<CodyBoardDto> codyBoardPageNation(int page) {
		int start = ((page-1) *10) +1;
		int end = start + 9;
		List<CodyBoardDto> codyBoardList = null;
		PageNationDto pageNationDto = new PageNationDto();
		pageNationDto.setStart(start);
		pageNationDto.setEnd(end);
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		codyBoardList = sqlSession.selectList("codyBoardPageNation", pageNationDto);
		return codyBoardList;
		
		
	}
	
	public int update(CodyBoardUpdateDto codyBoardUpdateDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("codyBoardUpdate", codyBoardUpdateDto);
		return result;
	}
	
	public int hit(int codyBoardNo) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("codyBoardHit", codyBoardNo);
		return result;
	}

	public int delete(int codyBoardNo) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("codyBoardDelete", codyBoardNo);
		if(result == 0) {
			throw new ELException("삭제실패");
		}
		return result;
	}

}
