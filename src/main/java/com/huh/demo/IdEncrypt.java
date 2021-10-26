package com.huh.demo;


public class IdEncrypt {
	
	public static String idEncrypt(String id){
	    if(id ==null || (id.length() < 8)){
	        return id;
	    }
//	    return id.replaceAll("(?<=\\w{3})\\w(?=\\w{2})", "*");
	    return id.replaceAll("(?<=\\w{2})\\w(?=\\w{1})", "*");
	}
public static void main(String[] args) {
	String idEncrypt = idEncrypt("421181198911036696");
	System.out.println(idEncrypt);
	String[] split = "123;".split(";");
	System.out.println(split);
	String[] split2 = "123".split(";");
	System.out.println(split2);
}
}
