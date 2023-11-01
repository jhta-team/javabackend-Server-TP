package com.kkj.follow.dao;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.kkj.follow.dto.FollowDto;
import com.kkj.mybatis.MybatisConnectionFactory;

import jakarta.el.ELException;

public class FollowDao {

	public int insert(FollowDto followDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("InsertFollow", followDto);
		return result;
		
	}

	public boolean checked(FollowDto followDto) {
		try{
			SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
			boolean followCheck = sqlSession.selectOne("FindOneFollow", followDto);
		
			System.out.println(followCheck);
			return followCheck;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}

	public boolean delete(FollowDto followDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteFollow", followDto);
		if(result > 0) {
			return true;
		}else {
			throw new ELException("에러입니다.");
		}
	}

	public int followCount(String userID) {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		int count = sqlSession.selectOne("countFollow", userID);
		System.out.println("followcount===>>>" + count);
		return count;
	}

	public int followerCount(String userID) {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		int count = sqlSession.selectOne("countFollower", userID);
		System.out.println("followercount===>>>" + count);
		return count;
	}
	

}
