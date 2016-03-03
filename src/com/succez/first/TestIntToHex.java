package com.succez.first;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIntToHex {

	@Test
	public void test() {
		assertEquals("0", IntToHex.intToHex(0));
		assertEquals("7fffffff", IntToHex.intToHex(Integer.MAX_VALUE));
		assertEquals("-80000000", IntToHex.intToHex(Integer.MIN_VALUE));
		assertEquals("-10", IntToHex.intToHex(-16));
		assertEquals("39702", IntToHex.intToHex(235266));
		assertEquals("-7fd2f", IntToHex.intToHex(-523567));
	}

}
