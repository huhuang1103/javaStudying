package com.huh.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock implements  Runnable{

    ReentrantLock lock = new ReentrantLock();



    public void get() {

        lock.lock();

        System.out.println(Thread.currentThread().getId());

        set();

        lock.unlock();

    }



    public void set() {

        lock.lock();

        System.out.println(Thread.currentThread().getId());

        lock.unlock();

    }



    @Override

    public void run() {

        get();

    }



    public static void main(String[] args) {

        TestReentrantLock ss = new TestReentrantLock();

        new Thread(ss).start();

        new Thread(ss).start();

        new Thread(ss).start();

    }


}
