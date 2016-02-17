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
public class ContainString_4 {

	public static boolean isBrother(String strSourceA, String strSourceB) {
		boolean isBrother = true;
		if (strSourceA.length() != strSourceB.length()) {
			isBrother = false;
		} else {
			char[] charA_array = strSourceA.toCharArray();
			char[] charB_array = strSourceB.toCharArray();
			// 1.排序
			quickSort(charA_array, 0, charA_array.length - 1);
			quickSort(charB_array, 0, charB_array.length - 1);
			// 2.遍历两个char数组，对比每一个字符，其实就是String里面的equals，但是我们这里不准备使用库函数
			int i = 0;
			int n = charA_array.length;
			while (n-- != 0) {
				if (charA_array[i] != charB_array[i]) {
					isBrother = false;
					break;
				}
				i++;
			}
		}
		return isBrother;
	}

	/**
	 * 快速排序
	 * 
	 * @param chars
	 * @param start
	 * @param end
	 */
	public static void quickSort(char[] chars, int start, int end) {
		if (start < end) {
			char base = chars[start]; // 选定的基准值（第一个数值作为基准值）
			char temp; // 记录临时中间值
			int i = start, j = end;
			do {
				while ((chars[i] < base) && (i < end))
					i++;
				while ((chars[j] > base) && (j > start))
					j--;
				if (i <= j) {
					temp = chars[i];
					chars[i] = chars[j];
					chars[j] = temp;
					i++;
					j--;
				}
			} while (i <= j);
			if (start < j)
				quickSort(chars, start, j);
			if (end > i)
				quickSort(chars, i, end);
		}
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
