package com.succez.first;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;

public class FileToByte {
	private static Logger log = Logger.getLogger(FileToByte.class.getName());

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
				throw new IllegalArgumentException("�ļ�������");
			}
			if (file.length() > Integer.MAX_VALUE) {
				throw new Exception("�ļ�̫���޷�����ת��");
			}
			fis = new FileInputStream(file);
			bos = new ByteArrayOutputStream((int) file.length());// ������1000���˷Ѻܶ���ʱ�ڴ�ռ�
			byte[] b = new byte[406];// ���������һ�ζ�4096����8192
			int i;
			while ((i = fis.read(b)) != -1) {
				bos.write(b, 0, i);

			}
			return bos.toByteArray();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				log.severe("�������ر�ʧ��");
			}
			try {
				if (bos != null)
					bos.close();
			} catch (Exception e) {
				log.severe("������ر�ʧ��");
			}
		}
	}
}
