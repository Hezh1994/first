package com.succez.first;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class FileToByte {
	/**
	 * 将指定文件转换为一个字节数组并返回,当文件过大将无法进行转换
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
				throw new Exception("文件太大，无法进行转换");
			}
			fis = new FileInputStream(file);
			bos = new ByteArrayOutputStream((int) file.length());// 这里用1000会浪费很多临时内存空间
			byte[] b = new byte[4096];// 读缓存最好一次读4096或者8192
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
