package com.kkj.cbreply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kkj.cbreply.dto.CbReplyDto;
import com.kkj.cbreply.dto.CbReplyUpdateDto;
import com.kkj.mybatis.MybatisConnectionFactory;

public class CbReplyDao {

	public int insert(CbReplyDto cbReplyDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertCbReply", cbReplyDto);
		return result;
	}
	
	public List<CbReplyDto> find(int cbBoardNo) {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		List<CbReplyDto> cbReplyList = sqlSession.selectList("findCbReply", cbBoardNo);
		System.out.println(cbReplyList);
		return cbReplyList;
	}

	public int update(CbReplyUpdateDto cbReplyUpdateDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateReply", cbReplyUpdateDto);
		return result;
	}

	public int delete(int replyNo) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteReply", replyNo);
		return result;
	}
	

}
