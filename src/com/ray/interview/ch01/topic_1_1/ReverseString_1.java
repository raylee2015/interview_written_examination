package com.ray.interview.ch01.topic_1_1;

/**
 * Ðý×ª×Ö·û´®
 * 
 * @author raylee
 * @date 2016-02-16
 * @version 1.0
 */
public class ReverseString_1 {

	private static String FirstCharToEnd(String source) {
		char[] charArray = source.toCharArray();
		char firstLetter = charArray[0];
		for (int i = 1; i < source.length(); i++) {
			charArray[i - 1] = charArray[i];
		}
		charArray[charArray.length - 1] = firstLetter;
		return new String(charArray);
	}

	public static String someCharsToEnd(String source, int countOfChar) {
		for (int i = 0; i < countOfChar; i++) {
			source = FirstCharToEnd(source);
		}
		return source;
	}

	public static void main(String[] args) {
		String source = "abcdef";
		System.out.println(someCharsToEnd(source, 3));
	}
}
