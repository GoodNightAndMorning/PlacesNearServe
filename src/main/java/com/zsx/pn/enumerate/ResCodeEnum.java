package com.zsx.pn.enumerate;

public enum ResCodeEnum {
    SUCCESS(1),
    FAILURE(0),
    UNVALID(2);

    private Integer code;

    private ResCodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
