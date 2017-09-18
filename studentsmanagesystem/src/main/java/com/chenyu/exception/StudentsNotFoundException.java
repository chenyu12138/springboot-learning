package com.chenyu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author chenyu
 * 2017/9/18 10:48
 */
@ResponseStatus(HttpStatus.NOT_FOUND)//指定状态码
public class StudentsNotFoundException extends RuntimeException {

    public StudentsNotFoundException() {
    }

    public StudentsNotFoundException(String message) {
        super(message);
    }

    public StudentsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
