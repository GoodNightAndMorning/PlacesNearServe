package com.zsx.pn.utils;

import com.zsx.pn.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

public class Utils {

    public static String createToken(String id) {
        String str = id + System.currentTimeMillis();
        String md5Str = null;
        try {
            md5Str = MD5.EncoderByMd5(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5Str;
    }
}
