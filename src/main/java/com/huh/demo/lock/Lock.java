package com.huh.demo.lock;

public class Lock{
    private boolean isLocked = false;
    public synchronized void lock() throws InterruptedException{
        while(isLocked){
            wait();//把当前线程wait
        }
        isLocked = true;
    }
    public synchronized void unlock(){
        isLocked = false;
        notify();//把当前线程notify
    }
}