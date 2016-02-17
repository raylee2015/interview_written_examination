package com.ray.interview.ch01.topic_1_1;

import java.util.Stack;
/**
 * Ðý×ª×Ö·û´®
 * 
 * @author raylee
 * @date 2016-02-16
 * @version 1.0
 */
public class ReverseString_4 {

	public static String reverse(String source, String regex) {
		String[] strArray = source.split(regex);
		Stack<String> stack = new Stack<String>();
		for (String item : strArray) {
			stack.push(item);
		}
		String rtnStr = "";
		while (!stack.isEmpty()) {
			rtnStr += stack.pop() + regex;
		}
		return rtnStr.trim();
	}

	public static void main(String[] args) {
		String source = "i am a student.";// student. a am i
		String regex = " ";
		System.out.println(reverse(source, regex));
	}
}
