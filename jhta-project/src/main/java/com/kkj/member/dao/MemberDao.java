package com.kkj.member.dao;


import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kkj.member.dto.MemberDto;
import com.kkj.mybatis.MybatisConnectionFactory;

public class MemberDao {
	public MemberDto loginMember(HashMap<String,String> loginMap) {
		MemberDto loginMemberDto =null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		loginMemberDto = sqlSession.selectOne("loginMember", loginMap);
		return loginMemberDto;
	}
	public int idCheckMember(String userID) {
		int result =0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("idCheck", userID);
		return result;
	}
}
