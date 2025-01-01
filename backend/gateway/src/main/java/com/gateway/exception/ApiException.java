package com.gateway.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -9078788239027473718L;
	private final HttpStatus status;

    public ApiException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() { return status; }
}
