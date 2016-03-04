package com.succez.first;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class FileToByte {
	/**
	 * ��ָ���ļ�ת��Ϊһ���ֽ����鲢����,���ļ������޷�����ת��
	 * 
	 * @param File
	 * @return byte[]
	 * @throws Exception
	 */
	public static byte[] fileToByte(File file) throws Exception {
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		try {
			if (file == null) {
				return null;
			}
			if ((int) file.length() > Integer.MAX_VALUE) {
				throw new Exception("�ļ�̫���޷�����ת��");
			}
			fis = new FileInputStream(file);
			bos = new ByteArrayOutputStream((int) file.length());// ������1000���˷Ѻܶ���ʱ�ڴ�ռ�
			byte[] b = new byte[4096];// ���������һ�ζ�4096����8192
			int i;
			while ((i = fis.read(b)) != -1) {
				bos.write(b, 0, i);

			}
			return bos.toByteArray();
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (bos != null)
				bos.close();
		}
	}
}
