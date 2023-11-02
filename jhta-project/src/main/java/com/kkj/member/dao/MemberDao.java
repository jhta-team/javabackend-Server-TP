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
	public int memberCount() {
		int result =0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("memberCount");
		return result;
	}
	public int noBlackMemberCount() {
		int result =0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		if(sqlSession.selectOne("noBlackMemberCount")==null) {
			result =0;
		}else {
			result = sqlSession.selectOne("noBlackMemberCount");
		}		
		return result;
	}
	public int blackMemberCount() {
		int result =0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("blackMemberCount");
		return result;
	}
	public int insertCount() {
		int result =0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("insertCount");
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
	public int deleteAdminMember(int no){
		int result=0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteAdminMember", no);
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
	public List<MemberDto> searhMember(HashMap<String,Object> map){
		List<MemberDto> searchList = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		searchList =sqlSession.selectList("searhMember", map);
		return searchList;
	}
	public int searhMemberCount(HashMap<String,Object> map) {
		int result =0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("searhMemberCount",map);
		return result;
	}
	public List<MemberDto> blackSearhMember(HashMap<String,Object> map){
		List<MemberDto> searchList = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		searchList =sqlSession.selectList("blackSearhMember", map);
		return searchList;
	}
	public int blackSearhMemberCount(HashMap<String,Object> map) {
		int result =0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("blackSearhMemberCount",map);
		return result;
	}
	public String findID(HashMap<String,String> map) {
		String id =null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		id = sqlSession.selectOne("findID",map);
		return id;
	}
	public int findPWChange(HashMap<String,String> map) {
		int result =0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("findPWChange", map);
		return result;
	}
	public String idCheckDelete(int no) {
		String id =null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		id = sqlSession.selectOne("idCheckDelete",no);
		return id;
	}
	public String imageMember(int no) {
		String id =null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		id = sqlSession.selectOne("imageMember",no);
		return id;
	}
}
