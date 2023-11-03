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
	public int loginCount() {
		int result=0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		if(sqlSession.selectOne("loginCount")==null) {
			result =0;
		}else {
			result = sqlSession.selectOne("loginCount");
		}		
		return result;
	}
	public int datnoReset() {
		int result=0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("datnoReset");
		return result;
	}
	public int deleteDate(String id) {
		int result=0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteDate",id);
		return result;
	}
}
