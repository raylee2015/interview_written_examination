package com.ray.interview.ch01.topic_1_1;

/**
 * Ðý×ª×Ö·û´®
 * 
 * @author raylee
 * @date 2016-02-16
 * @version 1.0
 */
public class ReverseString_2 {

	private static String reverse(String source, int start, int end) {
		char[] charArray = source.toCharArray();
		while (start < end) {
			char temp = charArray[start];
			charArray[start++] = charArray[end];
			charArray[end--] = temp;
		}
		return new String(charArray);
	}

	public static String reverse(String source, int pos) {
		if (pos > source.length()) {
			return "error:post is bigger than source's length";
		}
		source = reverse(source, 0, pos - 1);
		System.out.println(source);
		source = reverse(source, pos, source.length() - 1);
		System.out.println(source);
		source = reverse(source, 0, source.length() - 1);
		System.out.println(source);
		return source;
	}

	public static void main(String[] args) {
		String source = "abcdef";
		System.out.println(reverse(source, 3));
	}
}
