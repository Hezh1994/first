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
	 * 将指定文件转换为一个字节数组并返回
	 * 
	 * @param File
	 * @return byte[]
	 * @throws FileNotFoundException
	 *             ,IOException
	 */
	public static byte[] fileToByte(File file) throws FileNotFoundException,
			IOException {
		if (file == null) {
			throw new FileNotFoundException("文件不存在!");
		}
		try {
			INPUT_STREAM = new FileInputStream(file);
			OUTPUT_STREAM = new ByteArrayOutputStream(4096);// 这里用1000会浪费很多临时内存空间
			byte[] b = new byte[4096];// 读缓存最好一次读4096或者8192
			int i;
			while ((i = INPUT_STREAM.read(b)) != -1) {
				OUTPUT_STREAM.write(b, 0, i);

			}
			/**
			 * 有可能无法释放资源，前面会抛出异常导致程序中断。
			 */

			return OUTPUT_STREAM.toByteArray();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IOException("转换失败");
		} finally {
			if (INPUT_STREAM != null) {
				INPUT_STREAM.close();
			}
			if (OUTPUT_STREAM != null)
				OUTPUT_STREAM.close();
		}
	}
}
