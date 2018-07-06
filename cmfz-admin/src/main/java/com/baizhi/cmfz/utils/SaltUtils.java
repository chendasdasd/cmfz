package com.baizhi.cmfz.utils;

import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

public class SaltUtils {
	
	public static void main(String[] args) {
		//System.out.println(encryptionCode("123456"+getRandomSalt(6)));;
	}
	
	
	//�Բ���str���м���
	public static String encryptionCode(String str){
		return DigestUtils.md5Hex(str);
		//return DigestUtils.sha256Hex(str);
	}
	
	//�����ȡSalt
	public static String getRandomSalt(int len){//˽�γ���
		char[] chs="abcdefg1234567ABCDEFG".toCharArray();
		
		Random random =new Random();
		
		StringBuilder builder=new StringBuilder();//�ַ�ƴ��
		
		for (int i = 0; i < len; i++) {
			builder.append(chs[random.nextInt(chs.length)]);
		}
		
		return builder.toString();
	}
}
