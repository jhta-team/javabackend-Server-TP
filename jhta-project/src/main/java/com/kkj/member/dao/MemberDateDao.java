package com.kkj.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kkj.member.dto.MemberDateDto;
import com.kkj.mybatis.MybatisConnectionFactory;

public class MemberDateDao {
	public int loginDate(String userID) {
		int result=0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("loginDate",userID);
		return result;
	}
	public int insertDate(String userID) {
		int result=0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertDate",userID);
		return result;
	}
	public MemberDateDto loginCount() {
		MemberDateDto memberDateDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		memberDateDto = sqlSession.selectOne("loginCount");
		return memberDateDto;
	}
}
