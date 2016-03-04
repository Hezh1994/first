package com.succez.first;

import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestFileToByte {
	File file = new File("D:\\a.txt");
	File fileNull = null;
	File fileNotFound = new File("F:\\a.txt");

	@Test(expected = Exception.class)
	public void test() throws Exception {
		assertNotNull(FileToByte.fileToByte(file));
		assertNull(FileToByte.fileToByte(fileNull));
		FileToByte.fileToByte(fileNotFound);
	}
}
