package com.kkj.member.util;

import java.util.Random;

public class RandomEmailCheck {
	public int createRandomNum() {
			Random ran = new Random();
			int number = ran.nextInt(89999)+10000;
			return number;
	}
	public String createPassWord(){
		String str ="";
		Random ran = new Random();
		int num = ran.nextInt(899)+100;
		
		String strnum = Integer.toString(num);
		
		int innum = ran.nextInt(7);
		int numList[] =  {33,35,36,37,38,42,63,64};
		char str01 = (char)numList[innum];
		String str02 =Character.toString(str01);
		char array[] = new char[7];
		for(int i= 0;i<array.length ;i++) {
			int num01 = ran.nextInt(26)+96;
			array[i] = (char)num01;
			
		}
		str=String.valueOf(array);
		
		
		
		
		return str+strnum+str02;
	}
	

}
		
