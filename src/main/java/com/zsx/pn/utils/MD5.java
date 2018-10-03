package com.zsx.pn.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class MD5 {
    public static String EncoderByMd5(String str) throws Exception{
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
    public static boolean checkpassword(String newpasswd,String oldpasswd) throws Exception{
        if(EncoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }
}
