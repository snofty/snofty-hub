package com.snofty.mm.exception;

public class MMDBException extends Exception {

	private static final long serialVersionUID = 2576261751269865932L;

	public MMDBException(String message) {
		super(message);
	}

	public MMDBException(Throwable t, String message) {
		super(message, t);
	}

	public MMDBException(Throwable t) {
		super(t);
	}
}
