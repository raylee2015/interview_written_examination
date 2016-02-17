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
public class ContainString_3 {

	public static boolean isBrother(String strSourceA, String strSourceB) {
		boolean isBrother = true;
		if (strSourceA.length() != strSourceB.length()) {
			isBrother = false;
		} else {
			char[] charA_array = strSourceA.toCharArray();
			char[] charB_array = strSourceB.toCharArray();
			// ������ѯ
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
