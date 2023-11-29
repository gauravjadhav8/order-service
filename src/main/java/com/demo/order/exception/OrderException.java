package com.demo.order.exception;

/**
 * Custom Exception class for Order.
 */
public final class OrderException extends RuntimeException {
	private static final long serialVersionUID = -3115285058991721492L;

	public OrderException(final String msg) {
		super(msg);
	}
}