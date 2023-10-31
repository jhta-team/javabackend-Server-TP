package com.kkj.subscribe.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kkj.mybatis.MybatisConnectionFactory;
import com.kkj.subscribe.dto.SubscribeDto;
import com.kkj.subscribe.dto.SubscribePaymentDto;
import com.kkj.subscribe.dto.UpdateSubscribeDto;

public class SubscribeDao {

	public List<SubscribeDto> find() {
		List<SubscribeDto> subscribeKind = null; 
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		subscribeKind = sqlSession.selectList("findsubscribe");
		return subscribeKind;
	}

	public int payment(SubscribePaymentDto subscribeDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertSubscribePayment", subscribeDto);
		return result;
	}

	public int check(String imp_uid) {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		int count = sqlSession.selectOne("paymentCheck", imp_uid);
		System.out.println("결제내역 조회 디비에서"+count);
		return count;
	}

	public int updateSubscribeEnd(UpdateSubscribeDto updateSubscribeDto) {
		int result = 0; 
		System.out.println(updateSubscribeDto);
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateMemberSubscribe", updateSubscribeDto);
		System.out.println("result====>>>>" + result);
		return result;
	}

	public String plusDay(String product) {
		int day = Integer.parseInt(product.substring(0,2));
		Calendar subscribeEnd = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		subscribeEnd.add(Calendar.DATE, day);
		String changeDay = sdf1.format(subscribeEnd.getTime()); //현재날짜에서 구독일수만큼 더한값
		System.out.println("plusday===>>" + changeDay);
		return changeDay;
	}
	
	public String addSubscribe(String product, String mySubscribeEnd) {
		int day = Integer.parseInt(product.substring(0,2));
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String[] days = mySubscribeEnd.split("-");
		Calendar cal1 = Calendar.getInstance(); // 
		cal1.set(Integer.parseInt(days[0]), Integer.parseInt(days[1]) - 1, Integer.parseInt(days[2]) + day, Integer.parseInt(days[3]), Integer.parseInt(days[4]), Integer.parseInt(days[5]));
		String changeDay = sdf1.format(cal1.getTime());
		return changeDay;
	}
	
	public String subscribeDayFind(String userID) {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		String subscribeend = sqlSession.selectOne("subscribeDayFind", userID);
		System.out.println("subscribeend ===>>>" + subscribeend);
		return subscribeend;
	}

	public int checkday(String mySubscribeEnd) {
		System.out.println("mySubscribeEnd???? =>>>>" +mySubscribeEnd);
		String[] days = mySubscribeEnd.split("-");
		System.out.println("days???? =>>>>" + days[0]);
		
		Calendar cal1 = Calendar.getInstance(); // 현재 날짜와 시간
		System.out.println("111111111111111");
		Calendar cal2 = Calendar.getInstance(); // 내 db의 있는 시간
		System.out.println("111111111111111");
		cal2.set(Integer.parseInt(days[0]), Integer.parseInt(days[1]) -1, Integer.parseInt(days[2]), Integer.parseInt(days[3]), Integer.parseInt(days[4]), Integer.parseInt(days[5]));
		System.out.println("111111111111111");
		System.out.println("cal2???? =>>>>" + cal2.getTime());
		return cal1.compareTo(cal2);  // cal1 > cal2 1  cal < cal2  -1  cal = cal2 0
	}

	public List<SubscribePaymentDto> find(String userID) {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		List<SubscribePaymentDto> subscribePaymentList= sqlSession.selectList("findPayment", userID);
		return subscribePaymentList;
		
	}

}
