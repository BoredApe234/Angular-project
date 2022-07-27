package com.example.api.features;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.javafaker.Faker;

public class features {
/*	public static String encode(String str) {
		int i;
		char c;
		String encode = "";
		for(int in=0;in<str.length();in++) {
			c = str.charAt(in);
			i = (int)c;
			i+=in;
			c = (char)i;
			encode+=c;
		}
		return encode;
	}*/
	public static String encode(String str) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		 
         byte[] m = md.digest(str.getBytes(StandardCharsets.UTF_8));
         BigInteger number = new BigInteger(1, m);
         
         StringBuilder hexString = new StringBuilder(number.toString(16));
  
         while (hexString.length() < 64)
         {
             hexString.insert(0, '0');
         }
  
         return hexString.toString();
	}
	public static String decode(String str) {
		int i;
		char c;
		String encode = "";
		for(int in=0;in<str.length();in++) {
			c = str.charAt(in);
			i = (int)c;
			i-=in;
			c = (char)i;
			encode+=c;
		}
		return encode;
	}
	public static boolean goodpassword(String pass) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[-+_!@#$%^&*.,?]).+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(pass);
		if(m.matches())
			return true;
		return false;
		
	}
	public static String genUsername(String name) {
		Faker faker = new Faker();
        return (faker.superhero().prefix()+faker.name().firstName()+faker.address().buildingNumber());
	}
}
