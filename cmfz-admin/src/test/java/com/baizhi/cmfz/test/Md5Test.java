package com.baizhi.cmfz.test;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/11.
 */
public class Md5Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Md5Hash md5Hash = new Md5Hash("123456", "", 512);
        System.out.println(md5Hash);

        String replace = UUID.randomUUID().toString().replace("-", "");

        System.out.println(replace);
    }
}
