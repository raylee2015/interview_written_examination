package com.ray.interview.ch01.topic_1_2;

import java.util.HashMap;

/**
 * 检查字符串b里面的字符是否在a里面都出现过
 * 
 * @author raylee
 * @date 2016-02-16
 * @version 1.0
 */
public class ContainString_2 {

	public static boolean isContain(String a, String b) {
		boolean isContainStr = true;
		char[] charA_array = a.toCharArray();
		char[] charB_array = b.toCharArray();
		HashMap<Character, Character> map = new HashMap<>();
		for (int i = 0; i < charA_array.length; i++) {
			map.put(charA_array[i], charA_array[i]);
		}
		int sizeA = map.keySet().size();
		for (int i = 0; i < charB_array.length; i++) {
			map.put(charB_array[i], charB_array[i]);
		}
		int sizeB = map.keySet().size();
		if (sizeA < sizeB) {
			isContainStr = false;
		}
		return isContainStr;
	}

	public static void main(String[] args) {
		String a = "abc", b = "abb";
		System.out.println(isContain(a, b));
		String c = "abc", d = "aaa";
		System.out.println(isContain(c, d));
		String e = "cba", f = "ea";
		System.out.println(isContain(e, f));
	}

}
