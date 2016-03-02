package com.succez.first;

public class IntToHex {
	/**
	 * 
	 * @param i 十进制数
	 * @return 转换后的十六进制字符串
	 * 
	 * 定义一个字符串s，用来表示16以内的十进制数的十六进制
	 * 定义一个boolean类型变量bo，标记传入的是否为一个负数，初始值为false；若为负数则设为true并把i转为正数
	 * 用十进制数除以16，将余数对应的16进制数保存到StringBuffer中，若商不为0则继续除以16
	 * 若bo为true，则再加上一个'-'。
	 * 得到的StringBuffer与该十进制数的十六进制数是相反的，调用StrinBuffer的reverse()方法颠倒顺序
	 * 然后调用toString()方法并return十六进制字符串
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
