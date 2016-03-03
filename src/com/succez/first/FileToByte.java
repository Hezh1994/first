package com.succez.first;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileToByte {

	private static ByteArrayOutputStream OUTPUT_STREAM;
	private static FileInputStream INPUT_STREAM;

	/**
	 * ��ָ���ļ�ת��Ϊһ���ֽ����鲢����
	 * 
	 * @param File
	 * @return byte[]
	 * @throws FileNotFoundException
	 *             ,IOException
	 */
	public static byte[] fileToByte(File file) throws FileNotFoundException,
			IOException {
		if (file == null) {
			throw new FileNotFoundException("�ļ�������!");
		}
		try {
			INPUT_STREAM = new FileInputStream(file);
			OUTPUT_STREAM = new ByteArrayOutputStream(4096);// ������1000���˷Ѻܶ���ʱ�ڴ�ռ�
			byte[] b = new byte[4096];// ���������һ�ζ�4096����8192
			int i;
			while ((i = INPUT_STREAM.read(b)) != -1) {
				OUTPUT_STREAM.write(b, 0, i);

			}
			/**
			 * �п����޷��ͷ���Դ��ǰ����׳��쳣���³����жϡ�
			 */

			return OUTPUT_STREAM.toByteArray();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IOException("ת��ʧ��");
		} finally {
			if (INPUT_STREAM != null) {
				INPUT_STREAM.close();
			}
			if (OUTPUT_STREAM != null)
				OUTPUT_STREAM.close();
		}
	}
}
