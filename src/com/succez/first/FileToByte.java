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
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);//这里用1000会浪费很多临时内存空间
			byte[] b = new byte[1000];//读缓存最好一次读4096或者8192
			int i;
			while((i = fis.read(b)) != -1){
				bos.write(b, 0, i);
				
			}
			/**
			 * 有可能无法释放资源，前面会抛出异常导致程序中断。
			 */
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
