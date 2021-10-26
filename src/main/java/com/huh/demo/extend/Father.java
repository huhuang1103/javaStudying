package com.huh.demo.extend;


public class Father {
private String name;
private int age;
@Override
public String toString() {
	return "Father [name=" + name + ", age=" + age + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

public void speak() {
	System.out.println("father say hello");
}

}
