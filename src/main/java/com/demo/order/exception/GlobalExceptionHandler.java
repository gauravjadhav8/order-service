package com.demo.order.exception;

import java.net.ConnectException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@SuppressWarnings("static-method")
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<Object> handleResourceNotFound(final OrderException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("static-method")
	@ExceptionHandler(ConnectException.class)
	public ResponseEntity<Object> handleConnection(@SuppressWarnings("unused") final ConnectException e) {
		return new ResponseEntity<>("Host Service not available!", HttpStatus.SERVICE_UNAVAILABLE);
	}

	@SuppressWarnings({"static-method", "null"})
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<Object> handleHttpClientError(final HttpClientErrorException e) {
		return new ResponseEntity<>((e.getMessage().contains("Book") ? "Book" : "User") + " not available!", HttpStatus.NOT_FOUND);
	}
}