package com.huh.demo.extend;

public class TestExtend {
public static void main(String[] args) {
	Father father = new Son();
//	father.speak();
	
	Son son = (Son)father;
	son.play();
	son.speak();
	
//	Father father2 = new Father();
//	Son son2 = (Son) father2;
//	son2.speak();
//	son2.play();
	
	Son son3 = new Son();
	Father father3 = (Father) son3;
	father3.speak();
}
}
