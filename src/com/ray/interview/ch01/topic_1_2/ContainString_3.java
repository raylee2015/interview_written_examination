package com.ray.interview.ch01.topic_1_2;

/**
 * 搜查字典里面的兄弟字符串
 * 
 * 兄弟字符串概念：长度相同、字符完全相同、顺序不一定一样的字符串，例如“abc”和“cba”就是兄弟字符串，“aab”和“aba”也是
 * 
 * 在这里的字典我们为了方便，选用简单的字符串数组来替代，一般大的字典都是大数据的字符串文件
 * 
 * 
 * @author raylee
 * @date 2016-02-17
 * @version 1.0
 */
public class ContainString_3 {

	public static boolean isBrother(String strSourceA, String strSourceB) {
		boolean isBrother = true;
		if (strSourceA.length() != strSourceB.length()) {
			isBrother = false;
		} else {
			char[] charA_array = strSourceA.toCharArray();
			char[] charB_array = strSourceB.toCharArray();
			// 暴力轮询
			for (int i = 0; i < charA_array.length; i++) {
				for (int j = 0; j < charB_array.length; j++) {
					if (charA_array[i] == charB_array[j]) {
						charA_array[i] = charB_array[j] = 0;
						break;
					}
				}
			}
			for (int i = 0; i < charB_array.length; i++) {
				if (charB_array[i] != 0) {
					isBrother = false;
					break;
				}
			}
		}
		return isBrother;
	}

	public static void main(String[] args) {
		String[] source = { "abc", "cba", "abdc", "tec", "aab", "bbc", "bca" };
		String target = "abc";
		for (int i = 0; i < source.length; i++) {
			if (isBrother(source[i], target)) {
				System.out.println(source[i]);
			}
		}
	}

}
