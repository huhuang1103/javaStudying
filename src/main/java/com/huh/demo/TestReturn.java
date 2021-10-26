package com.huh.demo;

public class TestReturn {
public static void main(String[] args) {
//	int i=0;
//	i= start();
//	System.out.println(i);
//	Integer a= 2;
//	Integer b= 2;
//	System.out.println(a==b);
//	System.out.println(b==2);
//	Integer a=128; 
//	Integer b=128; 
//	System.out.println(a==b); 
	String s1="123";
	String s2=s1;
	String s3 = new String("123");
	String s4 = s3;
	System.out.println(s3 == s4);
	System.out.println(s3);
	System.out.println(s4);
	s3 = new String("123");
//	s3.valueOf("456");
	System.out.println(s3);
	System.out.println(s4);
	System.out.println(s3 == s4);
	System.out.println(s3.equals(s4));
}

private static int start() {
	try {
		System.out.println("try world");
		return 2;
//		throw new Exception();
	} catch (Exception e) {
		System.out.println("catch world");
		return 0;
	}finally {
		System.out.println("catch finally");
		return 1;
	}
}
}
