package com.succez.first;

public class WrongLevelException extends Exception {
	private static final long serialVersionUID = 1L;

	public WrongLevelException() {
		super();
	}

	public WrongLevelException(String s) {
		super(s);
	}
}
