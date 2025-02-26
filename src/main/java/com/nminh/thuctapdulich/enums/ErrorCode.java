package com.nminh.thuctapdulich.enums;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public enum ErrorCode {

    USER_EXIST(1001,"User existed",HttpStatus.BAD_REQUEST),
    LOGIN_FAILED(1002,"Login failed",HttpStatus.UNAUTHORIZED),
    EMAIL_INVALID_FORMAT(1003,"Invalid email format",HttpStatus.BAD_REQUEST),
    PHONE_INVALID_FORMAT(1004,"Invalid phone format",HttpStatus.BAD_REQUEST),
    DESTINATION_IS_EMPTY(1005,"Destination is empty",HttpStatus.BAD_REQUEST),
    TICKET_CLASS_NOT_FOUND(1006,"Ticket class not found",HttpStatus.BAD_REQUEST),
    ;
    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }
}
