package com.succez.first;

import java.io.File;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestFileToByte {
	File file = new File("D:/test.txt");
	File fileNull = null;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void test() throws Exception {
		assertEquals("1234567887654321",
				new String(FileToByte.fileToByte(file)));

		expectedEx.expect(NullPointerException.class);
		expectedEx.expectMessage("文件不存在");
		FileToByte.fileToByte(fileNull);

	}
}
