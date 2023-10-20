package com.kkj.member.util;

import java.util.Random;

public class RandomEmailCheck {
	public int createRandomNum() {
			Random ran = new Random();
			int number = ran.nextInt(89999)+10000;
			return number;
	}
}
		
