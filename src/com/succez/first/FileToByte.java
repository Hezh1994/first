package com.succez.first;

//import java.io.ByteArrayOutputStream;
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
		FileInputStream fis = null;
		// ByteArrayOutputStream bos = null;
		try {
			if (file == null) {
				throw new NullPointerException("�ļ�������");
			}
			if (file.length() > Integer.MAX_VALUE) {
				throw new CanNotTranslateException("�ļ�̫���޷�����ת��");
			}
			// fis = new FileInputStream(file);
			// bos = new ByteArrayOutputStream((int) file.length());//
			// ������1000���˷Ѻܶ���ʱ�ڴ�ռ�
			// byte[] b = new byte[4096];// ���������һ�ζ�4096����8192
			// int i;
			// while ((i = fis.read(b)) != -1) {
			// bos.write(b, 0, i);
			//
			// }
			// return bos.toByteArray();

			/**
			 * ����Ч�Ķ�ȡ����������Ҫ�м仺�棬ֱ�Ӷ����ֽ������С�
			 */
			fis = new FileInputStream(file);
			int i, off = 0;
			int fileLength = (int) file.length();
			int len = fileLength < 4096 ? fileLength : 4096;
			byte[] b = new byte[len];
			// ���len > b.length - off���׳�IndexOutOfBounds�쳣��
			while (off != fileLength) {
				i = fis.read(b, off, len);
				off += i;
			}
			return b;
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				log.severe("�������ر�ʧ��");
			}
			// try {
			// if (bos != null) {
			// bos.close();
			// }
			// } catch (Exception e) {
			// log.severe("������ر�ʧ��");
			// }
		}
	}
}
