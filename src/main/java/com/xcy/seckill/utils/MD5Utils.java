package com.xcy.seckill.utils;

import org.springframework.util.DigestUtils;
import sun.misc.BASE64Encoder;

public class MD5Utils {

    private static String  salt = "!Q@W#E$RRT%TT^YY";

    public static String getMD5(String str){
        String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
        BASE64Encoder base64Encoder =new BASE64Encoder();


        return base64Encoder.encode((md5+salt).getBytes());
    }

    public static void main(String[] args) {
        System.out.println(getMD5("123456"));
    }
}
