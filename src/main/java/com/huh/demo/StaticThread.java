package com.huh.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StaticThread
{
	public static void main(String[] args)
	{
		ExecutorService service = Executors.newFixedThreadPool(2);
		List<Future<String>> resultList = new ArrayList<Future<String>>();
		SyncObj syncObj = new SyncObj();
		
		for(int i=0; i<2; i++){
			Future<String> future = service.submit(new CallThread(syncObj, i));
			resultList.add(future);
		}
		
		for(int j=0; j<resultList.size(); j++){
			try
			{
				System.out.println(resultList.get(j).get());
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ExecutionException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		service.shutdown();
	}
	
}

class CallThread implements Callable<String>{

	private int id;
	private SyncObj syncObj;
	CallThread(SyncObj syncObj, int id){
		this.id = id;
		this.syncObj = syncObj;
	}
	@Override
	public String call() throws Exception
	{
		
		if(id%2 ==0){
			syncObj.getFun1(id);
		}else{
			syncObj.getStatic1(id);
		}

		return "线程 "+id+"执行完毕！";
	}
	
}

class SyncObj{
	public synchronized static void getStatic1(int id){
		System.out.println("线程 "+id+"进入getStatic1()！");
		for (int i = 0 ; i < 9999999; i--);
		System.out.println("线程 "+id+"退出getStatic1()！");
	}
	public synchronized static void getStatic2(int id){
		System.out.println("线程 "+id+"进入getStatic2()！");
		for (int i = 0 ; i < 9999999; i--);
		System.out.println("线程 "+id+"退出getStatic2()！");
	}
	public synchronized void getFun1(int id) throws InterruptedException{
		System.out.println("线程 "+id+"进入getFun1()！");
//		this.wait();
		for (int i = 0 ; i < 999999; i--);
		System.out.println("线程 "+id+"退出getFun1()！");
	}
	public  synchronized void getFun2(int id){
		System.out.println("线程 "+id+"进入getFun2()！");
		for (int i = 0 ; i < 9999999; i--);
		System.out.println("线程 "+id+"退出getFun2()！");
	}
}
