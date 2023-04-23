package com.code.basic.transaction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author FengDuo
 * @date 2023/4/23 16:00
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResult> baseExceptionHandler(Exception e, HttpServletRequest request) {
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        httpResult.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        httpResult.setData(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(httpResult);
    }
}
