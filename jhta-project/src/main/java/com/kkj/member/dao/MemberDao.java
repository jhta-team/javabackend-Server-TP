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
	public int insertMember(MemberDto memberDto){
		int result=0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertMember", memberDto);
		return result;
	}
	public int idCheckMember(String userID) {
		int result =0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("idCheck", userID);
		return result;
	}
	public int nickNameCheckMember(String nickName) {
		int result =0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("nickNameCheck", nickName);
		return result;
	}
	public MemberDto infoMember(String userID) {
		MemberDto memberDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		memberDto = sqlSession.selectOne("infoMember", userID);
		return memberDto;
	}
	public String passwordBlur(String userID) {
		String passwordBlur = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		passwordBlur = sqlSession.selectOne("passwordBlur", userID);
		return passwordBlur;
	}
}
