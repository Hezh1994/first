package com.succez.first;

public class IntToHex {
	private static String S = "0123456789abcdef";
	/**
	 * 定义一个字符串s，用来表示16以内的十进制数的十六进制
	 * 用十进制数除以16，将余数对应的16进制数保存到StringBuffer中，若商不为0则继续除以16 
	 * 得到的StringBuffer与该十进制数的十六进制数是相反的，调用StrinBuffer的reverse()方法颠倒顺序
	 * 然后调用toString()方法并return十六进制字符串
	 * 
	 * @param i
	 *            十进制数
	 * @return 转换后的十六进制字符串
	 * 
	 * 
	 */
	public static String intToHex(int i) {	
		
		/**
		 * 若传入一个负数...
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
