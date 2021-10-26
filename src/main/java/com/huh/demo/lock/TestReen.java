package com.huh.demo.lock;

public class TestReen {
    LockReen lock = new LockReen();
    public void print() throws  Exception{
        System.out.println(Thread.currentThread().getId() +"：print start");

        lock.lock();
        doAdd();
        lock.unlock();
        System.out.println(Thread.currentThread().getId() +"：print end");

    }
    public void doAdd() throws  Exception{
        System.out.println(Thread.currentThread().getId() +"：doAdd start");
        lock.lock();
        //do something
        lock.unlock();
        System.out.println(Thread.currentThread().getId() +"：doAdd end");

    }

    public  static  void main(String [] args) throws  Exception{
        TestReen testReen = new TestReen();
        testReen.print();
    }
}
