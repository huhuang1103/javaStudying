package com.huh.demo.lock;

/**
 * 可重入锁
 */
public class TestNonLock implements  Runnable{
    public synchronized void get(){

        System.out.println(Thread.currentThread().getId());

        set();

    }



    public synchronized void set(){

        System.out.println(Thread.currentThread().getId());

    }



    @Override

    public void run() {

        get();

    }

    public static void main(String[] args) {

        TestNonLock ss=new TestNonLock();

        new Thread(ss).start();

        new Thread(ss).start();

        new Thread(ss).start();

    }


}
