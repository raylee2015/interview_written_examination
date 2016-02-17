package com.ray.interview.ch01.topic_1_2;

/**
 * �Ѳ��ֵ�������ֵ��ַ���
 * 
 * �ֵ��ַ������������ͬ���ַ���ȫ��ͬ��˳��һ��һ�����ַ��������硰abc���͡�cba�������ֵ��ַ�������aab���͡�aba��Ҳ��
 * 
 * ��������ֵ�����Ϊ�˷��㣬ѡ�ü򵥵��ַ��������������һ�����ֵ䶼�Ǵ����ݵ��ַ����ļ�
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
			// 1.����
			quickSort(charA_array, 0, charA_array.length - 1);
			quickSort(charB_array, 0, charB_array.length - 1);
			// 2.��������char���飬�Ա�ÿһ���ַ�����ʵ����String�����equals�������������ﲻ׼��ʹ�ÿ⺯��
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
	 * ��������
	 * 
	 * @param chars
	 * @param start
	 * @param end
	 */
	public static void quickSort(char[] chars, int start, int end) {
		if (start < end) {
			char base = chars[start]; // ѡ���Ļ�׼ֵ����һ����ֵ��Ϊ��׼ֵ��
			char temp; // ��¼��ʱ�м�ֵ
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
