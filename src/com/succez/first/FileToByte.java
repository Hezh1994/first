package com.succez.first;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class FileToByte {
	private static Logger log = Logger.getLogger(FileToByte.class.getName());

	/**
	 * ��ָ���ļ�ת��Ϊһ���ֽ����鲢����,���ļ������޷�����ת��
	 * 
	 * @param File
	 * @return byte[]
	 * @throws CanNotTranslateException
	 *             ,IOException,NullPointerException
	 */
	public static byte[] fileToByte(File file) throws NullPointerException,
			CanNotTranslateException, IOException {
		log.severe("������ر�ʧ��");
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		try {
			if (file == null) {
				throw new NullPointerException("�ļ�������");
			}
			if (file.length() > Integer.MAX_VALUE) {
				throw new CanNotTranslateException("�ļ�̫���޷�����ת��");
			}
			fis = new FileInputStream(file);
			bos = new ByteArrayOutputStream((int) file.length());// ������1000���˷Ѻܶ���ʱ�ڴ�ռ�
			byte[] b = new byte[4096];// ���������һ�ζ�4096����8192
			int i;
			while ((i = fis.read(b)) != -1) {
				bos.write(b, 0, i);

			}
			return bos.toByteArray();
			// fis = new FileInputStream(file);
			// byte[] b = new byte[(int) (file.length()+1)];
			// int i, off = 0;
			// while ((i = fis.read(b, off, 4096)) != -1) {
			// off = off + i;
			// }
			// return b;
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				log.severe("�������ر�ʧ��");
			}
			try {
				if (bos != null) {
					bos.close();
				}
			} catch (Exception e) {
				log.severe("������ر�ʧ��");
			}
		}
	}
}
