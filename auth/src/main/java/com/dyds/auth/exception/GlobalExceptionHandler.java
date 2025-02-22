package com.dyds.auth.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ErrorResponse> handleAuthException(AuthException ex) {
        return ResponseEntity.status(ex.getStatusCode())
            .body(new ErrorResponse(ex.getCode(), ex.getMessage()));
    }

    public record ErrorResponse(int code, String message) {}
}

@SuppressWarnings("serial")
class AuthException extends RuntimeException {
    private final int code;
    private final int statusCode;

    public AuthException(int code, String message, int statusCode) {
        super(message);
        this.code = code;
        this.statusCode = statusCode;
    }

    // Getters
    public int getCode() { return code; }
    public int getStatusCode() { return statusCode; }
}