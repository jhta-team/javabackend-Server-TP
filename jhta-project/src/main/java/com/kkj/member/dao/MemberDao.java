package com.kkj.member.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	public MemberDto infoModify(HashMap<String,String> modifyMap) {
		MemberDto loginMemberDto =null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		loginMemberDto = sqlSession.selectOne("infoModify", modifyMap);
		return loginMemberDto;
	}
	public int infoUpdateMember(MemberDto memberDto){
		int result=0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("infoUpdateMember", memberDto);
		return result;
	}
	public int deleteMember(HashMap<String,String> deleteMap){
		int result=0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteMember", deleteMap);
		return result;
	}
	public List<MemberDto> listMember(HashMap<String,Integer> map){
		List<MemberDto> memberList = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		memberList =sqlSession.selectList("listMember", map);
		return memberList;
	}
	public List<MemberDto> blackListMember(HashMap<String,Integer> map){
		List<MemberDto> blackList = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		blackList =sqlSession.selectList("blackListMember", map);
		return blackList;
	}
	public int blackUpdate(HashMap<String,Integer> map) {
		int result=0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("blackUpdate", map);
		return result;
	}
	public int blackUpdateAll(HashMap<String,Integer> map) {
		int result=0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("blackUpdateAll", map);
		return result;
	}
}
