package com.huh.task;

import java.util.concurrent.Callable;

public class Order implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println("执行更新");
		return "返回结果状态码";
	}

}
