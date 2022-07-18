package com.example.api.features;

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
}
