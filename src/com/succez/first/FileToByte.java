package com.succez.first;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class FileToByte {
	/**
	 * @param file
	 * @return byte[]
	 * ����һ��File���󣬶�ȡ�ļ����ݣ�����һ��byte����
	 * ͨ��ByteArrayOutputSteam�����ڴ滺����������,ת�����ֽ����顣
	 */
	public static byte[] fileToByte(File file) {
		if (file == null) {
			return null; //���ļ������ڷ���null
		}
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);//������1000���˷Ѻܶ���ʱ�ڴ�ռ�
			byte[] b = new byte[1000];//���������һ�ζ�4096����8192
			int i;
			while((i = fis.read(b)) != -1){
				bos.write(b, 0, i);
				
			}
			/**
			 * �п����޷��ͷ���Դ��ǰ����׳��쳣���³����жϡ�
			 */
			fis.close();
			bos.close();
			return bos.toByteArray();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; //��ȡʧ�ܣ���ӡ�쳣������null;
		}
	}
}
