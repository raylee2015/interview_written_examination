package com.ray.interview.ch01.topic_1_2;

import java.util.HashMap;
import java.util.Iterator;

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
public class ContainString_5 {

	public static boolean isBrother(String strSourceA, String strSourceB) {
		boolean isBrother = true;
		if (strSourceA.length() != strSourceB.length()) {
			isBrother = false;
		} else {
			char[] charA_array = strSourceA.toCharArray();
			char[] charB_array = strSourceB.toCharArray();

			// 1.���ַ��ŵ�ɢ�б�����
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

			// 2.�Ա�ɢ�б�
			if (mapA.size() != mapB.size()) {// �����ַ���ͬ�����map��size��ͬ����ͬ����
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
