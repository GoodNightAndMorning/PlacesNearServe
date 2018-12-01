package com.zsx.pn.dto;

import com.zsx.pn.enumerate.ResCodeEnum;
import com.zsx.pn.utils.Constant;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;


public class BaseResult {

    public static String vaildParams(BindingResult result) {
        if (result.hasErrors()) {

            ObjectError error = result.getAllErrors().get(0);
            String message = error.getDefaultMessage();

            return message;
        }
        return null;
    }

    public static BaseDto success(Object data, String message) {
        return new BaseDto(message, data, ResCodeEnum.SUCCESS.getCode());

    }
    public static BaseDto success(String message) {
        return new BaseDto(message, ResCodeEnum.SUCCESS.getCode());
    }

    public static BaseDto failure(String message) {
        if (Constant.TOKEN_UNVALID_STR.equals(message)) {
            return new BaseDto(Constant.TOKEN_UNVALID_STR, ResCodeEnum.UNVALID.getCode());
        }else {
            return new BaseDto<>(message, ResCodeEnum.FAILURE.getCode());
        }

    }
}
