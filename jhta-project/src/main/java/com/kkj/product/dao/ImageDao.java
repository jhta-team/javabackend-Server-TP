package com.kkj.product.dao;

import org.apache.ibatis.session.SqlSession;

import com.kkj.mybatis.MybatisConnectionFactory;
import com.kkj.product.dto.ImageDto;

public class ImageDao {
	
	public ImageDto selectOneImg(int pdtId) { // 상품 ID 값으로 상품 이미지 테이블 전체 정보 가져오는 메서드
		ImageDto imageDto = new ImageDto();
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		imageDto = sqlSession.selectOne("selectOneImage",pdtId);
		sqlSession.close();
		return imageDto; 
	}
	
	public int insertImg(ImageDto imageDto){ 
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("insertImage", imageDto);
		sqlSession.close();
		return result;
	}
	public int updateImg(ImageDto imageDto){ 
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateImage", imageDto);
		sqlSession.close();
		return result;
	}

	public int deleteImg(int pdtId) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("deleteImage", pdtId);
		sqlSession.close();
		return result;
	}
}
