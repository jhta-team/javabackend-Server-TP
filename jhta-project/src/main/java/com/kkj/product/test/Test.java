package com.kkj.product.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("S", 1);
		map.put("M", 2);
		map.put("L", 3);
		map.put("XL", 4);		
		System.out.println(map.values());
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("[key]:" + entry.getKey() + ", [value]:" + entry.getValue());
		}
		
		List<Map<String,Integer>> list = new ArrayList<>();
		list.add(map);
	}
}
