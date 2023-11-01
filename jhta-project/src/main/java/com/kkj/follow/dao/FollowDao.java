package com.kkj.follow.dao;

import java.util.HashMap;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.kkj.follow.dto.FollowDto;
import com.kkj.mybatis.MybatisConnectionFactory;

import jakarta.el.ELException;

public class FollowDao {

	public HashMap<String,Integer> insert(FollowDto followDto) throws Exception {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("InsertFollow", followDto);
		if(result > 0) {
			int followCount = sqlSession.selectOne("countFollow", followDto.getMyID());
			System.out.println("followcount===>>>" + followCount);
			int followerCount = sqlSession.selectOne("countFollower", followDto.getFollowID());
			System.out.println("followercount===>>>" + followerCount);
			HashMap<String,Integer> count = new HashMap<String, Integer>();
			count.put("followCount", followCount);
			count.put("followerCount", followerCount);
			return count;
		}else {
			throw new ELException("에러입니다.");
		}
		
		
		
	}

	public boolean checked(FollowDto followDto) {
//		try{
//			SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
//			int followCheck = sqlSession.selectOne("FindOneFollow", followDto);
//		
//			System.out.println("==========================>>>>>>>"+followCheck);
//			return followCheck;
//		}catch(Exception e) {
//			System.out.println(e);
//			return 0;
//		}
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		
		 FollowDto followCheck = sqlSession.selectOne("FindOneFollow", followDto);
		 System.out.println(followCheck);
		 Optional<FollowDto> followIsNull = Optional.ofNullable(followCheck);
		System.out.println("+=======>>>" + followIsNull.isPresent());
		return followIsNull.isPresent();
		
	}

	public HashMap<String,Integer> delete(FollowDto followDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteFollow", followDto);
		if(result > 0) {
			int followCount = sqlSession.selectOne("countFollow", followDto.getMyID());
			System.out.println("followcount===>>>" + followCount);
			int followerCount = sqlSession.selectOne("countFollower", followDto.getFollowID());
			System.out.println("followercount===>>>" + followerCount);
			HashMap<String,Integer> count = new HashMap<String, Integer>();
			count.put("followCount", followCount);
			count.put("followerCount", followerCount);
			return count;
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
