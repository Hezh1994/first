package com.succez.first;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntToHexTest {

	@Test
	public void test() {
		assertEquals("-10", IntToHex.intToHex(-16));
	}

}
