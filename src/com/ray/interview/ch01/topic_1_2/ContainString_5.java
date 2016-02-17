package com.ray.interview.ch01.topic_1_2;

import java.util.HashMap;
import java.util.Iterator;

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
public class ContainString_5 {

	public static boolean isBrother(String strSourceA, String strSourceB) {
		boolean isBrother = true;
		if (strSourceA.length() != strSourceB.length()) {
			isBrother = false;
		} else {
			char[] charA_array = strSourceA.toCharArray();
			char[] charB_array = strSourceB.toCharArray();

			// 1.把字符放到散列表里面
			HashMap<Character, Integer> mapA = new HashMap<>();
			for (int i = 0; i < charA_array.length; i++) {
				if (mapA.get(charA_array[i]) == null) {
					mapA.put(charA_array[i], 1);
				} else {
					mapA.put(charA_array[i], mapA.get(charA_array[i]) + 1);
				}
			}

			HashMap<Character, Integer> mapB = new HashMap<>();
			for (int i = 0; i < charB_array.length; i++) {
				if (mapB.get(charB_array[i]) == null) {
					mapB.put(charB_array[i], 1);
				} else {
					mapB.put(charB_array[i], mapB.get(charB_array[i]) + 1);
				}
			}

			// 2.对比散列表
			if (mapA.size() != mapB.size()) {// 由于字符相同，因此map的size相同，不同则不是
				isBrother = false;
			} else {
				Iterator<Character> keyIterator = mapA.keySet().iterator();
				while (keyIterator.hasNext()) {
					Character key = (Character) keyIterator.next();
					if (mapA.get(key) != mapB.get(key)) {
						isBrother = false;
						break;
					}
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
