package com.huh.demo.lock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock implements  Runnable{

    private AtomicReference<Thread> owner =new AtomicReference<Thread>();

    public void lock(){
        System.out.println("start");

        Thread current = Thread.currentThread();

        while(!owner.compareAndSet(null, current)){

        }

        System.out.println("end");

    }

    public void unlock (){

        Thread current = Thread.currentThread();

        owner.compareAndSet(current, null);

        System.out.println("unlock end");

    }


    public void run() {
        lock();
        lock();
    }

    public static  void main(String [] args){
        SpinLock spinLock = new SpinLock();
//        new Thread(spinLock).start();
        spinLock.lock();
        spinLock.unlock();
    }
}
