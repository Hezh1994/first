package com.succez.first;

public class IntToHex {
	/**
	 * 
	 * @param i ʮ������
	 * @return ת�����ʮ�������ַ���
	 * 
	 * ����һ���ַ���s��������ʾ16���ڵ�ʮ��������ʮ������
	 * ����һ��boolean���ͱ���bo����Ǵ�����Ƿ�Ϊһ����������ʼֵΪfalse����Ϊ��������Ϊtrue����iתΪ����
	 * ��ʮ����������16����������Ӧ��16���������浽StringBuffer�У����̲�Ϊ0���������16
	 * ��boΪtrue�����ټ���һ��'-'��
	 * �õ���StringBuffer���ʮ��������ʮ�����������෴�ģ�����StrinBuffer��reverse()�����ߵ�˳��
	 * Ȼ�����toString()������returnʮ�������ַ���
	 */
	public static String intToHex(int i) {
		String s = "0123456789ABCDEF ";
		int a = 0;
		boolean bo= false;
		StringBuffer sb = new StringBuffer();
		if(i < 0){
			bo = true;
			i= Math.abs(i);
		}
		do {
			a = i % 16;
			i = i / 16;
			sb.append(s.charAt(a));
		} while (i !=0 );
		if(bo){
			sb.append('-');
		}
		return sb.reverse().toString();
	}
}
