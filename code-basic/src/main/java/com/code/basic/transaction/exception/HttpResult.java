package com.code.basic.transaction.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * global response entity
 *
 * @author FengDuo
 * @date 2023/4/23 16:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResult implements Serializable {

    private static final HttpResult SUCCESS_RESULT = new HttpResult(HttpStatus.OK.value(), null, HttpStatus.OK.getReasonPhrase());

    /**
     * http status code, {@link HttpStatus#value()}
     */
    private Integer code;

    private Object data;

    private String message;

    public static HttpResult success() {
        return SUCCESS_RESULT;
    }

    public static HttpResult success(Object data) {
        return new HttpResult(HttpStatus.OK.value(), data, HttpStatus.OK.getReasonPhrase());
    }

    public static HttpResult success(Object data, String message) {
        return new HttpResult(HttpStatus.OK.value(), data, message);
    }

}
