package com.kkj.subscribe.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;

import com.kkj.mybatis.MybatisConnectionFactory;
import com.kkj.subscribe.dto.SubscribePaymentDto;
import com.kkj.subscribe.dto.UpdateSubscribeDto;

public class SubscribeCancelDao {

	public int insert(SubscribePaymentDto subscribePaymentDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertSubscribePaymentCancel", subscribePaymentDto);
		return result;
	}

	public UpdateSubscribeDto findOne(String userID) {
		UpdateSubscribeDto updateSubscribeDto = new UpdateSubscribeDto();
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		updateSubscribeDto = sqlSession.selectOne("findeOnePayment", userID);
		System.out.println("fineOne");
		System.out.println(updateSubscribeDto);
		System.out.println("fineOne");
		return updateSubscribeDto;
		
	}

	public UpdateSubscribeDto changeDay(UpdateSubscribeDto updateSubscribeDto, String product) {
		int day = Integer.parseInt(product.substring(0,2));
		Calendar cal = Calendar.getInstance();
		String[] days = updateSubscribeDto.getSubscribeEnd().split("-");
		cal.set(Integer.parseInt(days[0]), Integer.parseInt(days[1]) - 1, Integer.parseInt(days[2]) - day, Integer.parseInt(days[3]), Integer.parseInt(days[4]), Integer.parseInt(days[5]));
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String changeDay = sdf1.format(cal.getTime());
		updateSubscribeDto.setSubscribeEnd(changeDay);
		System.out.println("체인지데이안");
		System.out.println(updateSubscribeDto);
		System.out.println("체인지데이안");
		return updateSubscribeDto;
		
		
	}

	public int update(UpdateSubscribeDto updateSubscribeDto) {
		int result = 0;
		System.out.println("업데이트안!!!!");
		System.out.println(updateSubscribeDto);
		System.out.println("업데이트안!!!!");
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateMemberSubscribe", updateSubscribeDto);
		return result;
		
	}

}
