package com.succez.first;

public class IntToHex {
	private static String S = "0123456789abcdef";
	/**
	 * ����һ���ַ���s��������ʾ16���ڵ�ʮ��������ʮ������
	 * ��ʮ����������16����������Ӧ��16���������浽StringBuffer�У����̲�Ϊ0���������16 
	 * �õ���StringBuffer���ʮ��������ʮ�����������෴�ģ�����StrinBuffer��reverse()�����ߵ�˳��
	 * Ȼ�����toString()������returnʮ�������ַ���
	 * 
	 * @param i
	 *            ʮ������
	 * @return ת�����ʮ�������ַ���
	 * 
	 * 
	 */
	public static String intToHex(int i) {	
		
		/**
		 * ������һ������...
		 */
		
		int a = 0;
		StringBuffer sb = new StringBuffer();//StringBuffer sb = new StringBuffer(9)
		do {
			a = i % 16;
			i = i / 16;
			sb.append(S.charAt(a));
		} while (i != 0);
		return sb.reverse().toString();
	}
}
