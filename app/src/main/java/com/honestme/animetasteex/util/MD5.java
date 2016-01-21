package com.honestme.animetasteex.util;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2015/11/2 0002.
 */
public class MD5 {
    static final String HEX = "0123456789abcdef";

    private static String getHex(byte[] raw){
        if(raw == null){
            return null;
        }

        final StringBuilder hex = new StringBuilder(2 * raw.length);
        for(byte b : raw){
            hex.append(b & 0xFF);

        }

        return hex.toString();


    }

    public static String digest(String toMd5){
        MessageDigest md5;
        try{
            md5 = MessageDigest.getInstance("MD5");
            md5.update(toMd5.getBytes());
            return getHex(md5.digest());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
