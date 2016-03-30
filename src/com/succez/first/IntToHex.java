package com.succez.first;

public class IntToHex {
	private static char[] HEX_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * ��һ��ʮ������ת��Ϊʮ�����ƣ�������ʮ�������ַ������磺intToHex(Integer.MAX_VALUE),����7fffffff��
	 * 
	 * @param i
	 *            ʮ������
	 * @return ʮ���������ַ���
	 */
	public static String intToHex(int i) {
		if (i == Integer.MIN_VALUE) {
			return "-80000000";
		}
		boolean isNegatives = false;
		if (i < 0) {
			isNegatives = true;
			i = Math.abs(i);
		}
		int a = 0;
		StringBuilder sb = new StringBuilder(9);
		do {
			a = i & 15;
			i = i >> 4;
			sb.append(HEX_CHARS[a]);
		} while (i != 0);
		if (isNegatives) {
			sb.append('-');
		}
		return sb.reverse().toString();
	}
}
