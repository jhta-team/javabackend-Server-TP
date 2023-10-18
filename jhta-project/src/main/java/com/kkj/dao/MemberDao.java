package com.kkj.dao;

import org.apache.ibatis.session.SqlSession;

import com.kkj.mybatis.MybatisConnectionFactory;

public class MemberDao {
	public int idCheckMember(String userID) {
		int result =0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("idCheck", userID);
		return result;
	}
}
