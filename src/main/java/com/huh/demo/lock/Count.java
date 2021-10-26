package com.huh.demo.lock;


public class Count{
    Lock lock = new Lock();
    public void print() throws  Exception{
        System.out.println("print start");

        lock.lock();
        doAdd();
        lock.unlock();
        System.out.println("print end");

    }
    public void doAdd() throws  Exception{
        System.out.println("doAdd start");
        lock.lock();
        //do something
        lock.unlock();
        System.out.println("doAdd end");

    }

    public  static  void main(String [] args) throws  Exception{
        Count count = new Count();
        count.print();
    }
}
