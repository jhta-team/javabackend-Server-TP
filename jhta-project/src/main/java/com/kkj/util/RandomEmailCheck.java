package com.kkj.util;

import java.util.Random;

public class RandomEmailCheck {
	public int createRandomNum() {
			Random ran = new Random();
			int number = ran.nextInt(90000);
			return number;
	}
}
		
