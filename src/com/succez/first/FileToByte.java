package com.succez.first;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class FileToByte {
	/**
	 * @param file
	 * @return byte[]
	 * 输入一个File对象，读取文件内容，返回一个byte数组
	 * 通过ByteArrayOutputSteam捕获内存缓冲区的数据,转换成字节数组。
	 */
	public static byte[] fileToByte(File file) {
		if (file == null) {
			return null; //当文件不存在返回null
		}
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];
			int i;
			while((i = fis.read(b)) != -1){
				bos.write(b, 0, i);
				
			}
			fis.close();
			bos.close();
			return bos.toByteArray();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; //读取失败，打印异常，返回null;
		}
	}
}
