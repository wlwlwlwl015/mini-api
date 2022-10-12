package com.wl.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    private final static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public final static String MD5(String s) {
        try {
            byte[] btInput = s.getBytes("utf-8");
            return encode(btInput);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String encode(byte[] btInput) throws NoSuchAlgorithmException {
        MessageDigest mdInst = MessageDigest.getInstance("MD5");
        mdInst.update(btInput);
        byte[] md = mdInst.digest();
        int j = md.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }


    public static String MD5Salt(String rawPass, String salt) {
        try {
            byte[] btInput = (rawPass + salt).getBytes("utf-8");
            return encode(btInput);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
