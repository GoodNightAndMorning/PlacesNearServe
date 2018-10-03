package com.zsx.pn.dto;

public class BaseDto<T> {
    private Integer code;
    private String message;
    private T data;

    public BaseDto(String message, T data, Integer code) {

        this.message = message;
        this.data = data;
        this.code = code;
    }

    public BaseDto(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public BaseDto() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseDto{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
