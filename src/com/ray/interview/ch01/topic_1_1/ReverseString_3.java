package com.ray.interview.ch01.topic_1_1;

/**
 * Ðý×ª×Ö·û´®
 * 
 * @author raylee
 * @date 2016-02-16
 * @version 1.0
 */
public class ReverseString_3 {

	public static String reverse(String source, String regex, int start, int end) {
		String[] strArray = source.split(regex);
		while (start < end) {
			String temp = strArray[start];
			strArray[start++] = strArray[end];
			strArray[end--] = temp;
		}
		String rtnStr = "";
		for (int i = 0; i < strArray.length; i++) {
			rtnStr += strArray[i] + regex;
		}
		return rtnStr.trim();
	}

	public static void main(String[] args) {
		String source = "i am a student.";// student. a am i
		String regex = " ";
		System.out.println(reverse(source, regex, 0, source.split(regex).length - 1));
	}
}
