package com.ray.interview.ch01.topic_1_2;

/**
 * 检查字符串b里面的字符是否在a里面都出现过
 * 
 * @author raylee
 * @date 2016-02-16
 * @version 1.0
 */
public class ContainString_1 {

	public static boolean isContain(String a, String b) {
		boolean isContainStr = true;
		char[] charA_array = a.toCharArray();
		char[] charB_array = b.toCharArray();
		for (int i = 0; i < charB_array.length; i++) {
			boolean isContainChar = false;
			for (int j = 0; (j < charA_array.length); j++) {
				if (charA_array[j] == charB_array[i]) {
					isContainChar = true;
					break;
				}
			}
			if (!isContainChar) {
				isContainStr = false;
				break;
			}
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
