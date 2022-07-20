package com.example.api.features;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class features {
	public static String encode(String str) {
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
}
