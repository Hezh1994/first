package com.succez.first;

public class IntToHex {
	private static char[] HEX_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * 将一个十进制数转换为十六进制，并返回十六进制字符串。如：intToHex(Integer.MAX_VALUE),返回7fffffff。
	 * @param i
	 *            十进制数
	 * @return 十六进制数字符串
	 */
	public static String intToHex(int i) {
		boolean isNegatives = false;
		if(i == Integer.MIN_VALUE){
			return "-80000000";
		}
		if (i < 0) {
			isNegatives = true;
			i = Math.abs(i);
		}
		int a = 0;
		StringBuilder sb = new StringBuilder(9);
		do {
			a = i % 16;
			i = i / 16;
			sb.append(HEX_CHARS[a]);
		} while (i != 0);
		if (isNegatives) {
			sb.append('-');
		}
		return sb.reverse().toString();
	}
}
