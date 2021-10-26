package com.huh.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task {

	public static void main(String[] args) {
		
		ExecutorService executorServices = Executors.newFixedThreadPool(100);
		List tasks = new ArrayList<Order>();
		tasks.add(new Order());
		try {
			executorServices.invokeAll(tasks);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		List<Future<String>> futureList = new ArrayList<Future<String>>();

		for (int i = 0; i < 5; i++) {
			Future<String> result = executorService.submit(new Order());
			futureList.add(result);
		}
		executorService.shutdown();
		
		for (Future<String> future : futureList) {
	        try {
	            while (true) {
	                if (future.isDone() && !future.isCancelled()) {
	                    String string = future.get();
						System.out.println("Future:" + future
	                            + ",Result:" + string);
	                    break;
	                } 
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	}
 }	
}
