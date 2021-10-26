package com.huh.demo;

public class A {

	/**
	 * 静态方法
	 */
	public synchronized static void staticMethod() {
	}

	/**
	 * 实例方法
	 */
	public synchronized void instanceMethod() {
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		// A实例的创建过程
		Class c = Class.forName("com.cn.demo.A");
		A a1 = (A) c.newInstance();
		A a2 = (A) c.newInstance();
		A a3 = (A) c.newInstance();
		InnerClass innerClass =new A().new InnerClass();
		innerClass.setAge(100);
		System.out.println(innerClass);
	}

	class InnerClass {
		int age;
		/*static*/ String name;

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "InnerClass [age=" + age + ", name=" + name + "]";
		}
		

	}
}
