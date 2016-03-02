package com.succez.first;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntToHexTest {
	int i = 5363;

	@Test
	public void test() {
		assertEquals(Integer.toHexString(i), IntToHex.intToHex(i));
	}

}
