package com.jy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		char[] sentence = new StringBuilder("I am a student.").toString().toCharArray();
		System.out.println("输入的字符串: " + String.valueOf(sentence));
		reverseSentence(sentence);
		System.out.println("翻转后字符串: " + String.valueOf(sentence));

		System.out.println("----------分隔线----------");

		char[] data = new StringBuilder("abcdefghijk").toString().toCharArray();
		System.out.println("输入的字符串: " + String.valueOf(data));

		Scanner scanner = new Scanner(System.in);
		System.out.print("左旋位数n:");
		int n = scanner.nextInt();

		leftRotateString(data, n);
		System.out.println("左旋" + n + "字符串: " + String.valueOf(data));

		scanner.close();
	}

	/**
	 * 翻转句子
	 * 
	 * @param data
	 *            待翻转句子的字符串数组
	 */
	public static void reverseSentence(char[] data) {
		int length = data.length;
		if (data == null || length <= 1)
			return;
		// 先翻转整个句子
		reverse(data, 0, length - 1);
		// 再翻转句子中以空格分隔开的每个单词
		int start = 0;
		int end = 0;
		while (start < length) {
			if (data[start] == ' ') {
				// 第一个非空格作为单词的开头
				start++;
				end++;
			} else if (data[end] == ' ' || end == length - 1) {
				// 以为空格作为单词的结束
				reverse(data, start, end - 1);
				end++;
				start = end;
			} else {
				end++;
			}
		}

	}

	/**
	 * 左旋字符串
	 * 
	 * @param data
	 *            待左旋的字符串
	 * @param n
	 *            左边多少个字符做左旋
	 */
	public static void leftRotateString(char[] data, int n) {
		int length = data.length;
		if (data == null || length <= 1 || n > length)
			return;
		// 用左旋转的个数n将字符串分成两部分
		// 先分别翻转这两部分
		reverse(data, 0, n - 1);
		reverse(data, n, length - 1);
		// 再翻转整个字符串
		reverse(data, 0, length - 1);
	}

	/**
	 * 翻转字符串
	 * 
	 * @param data
	 *            待翻转的字符串数组
	 * @param start
	 *            数组中翻转范围开始的索引
	 * @param end
	 *            数组中翻转范围结束的索引
	 */
	public static void reverse(char[] data, int start, int end) {
		int length = data.length;
		if (data == null || start >= length || end >= length)
			return;
		// 头尾交换开始翻转
		while (start < end) {
			char temp = data[start];
			data[start] = data[end];
			data[end] = temp;
			start++;
			end--;
		}
	}

}
