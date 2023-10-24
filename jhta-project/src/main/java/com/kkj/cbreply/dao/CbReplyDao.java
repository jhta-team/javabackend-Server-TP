package com.kkj.cbreply.dao;

import org.apache.ibatis.session.SqlSession;

import com.kkj.cbreply.dto.CbReplyDto;
import com.kkj.mybatis.MybatisConnectionFactory;

public class CbReplyDao {

	public int insert(CbReplyDto cbReplyDto) {
		int result = 0;
		System.out.println("111111");
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		System.out.println("111111");
		result = sqlSession.insert("insertCbReply", cbReplyDto);
		System.out.println("111111");
		return result;
		
	}

}
