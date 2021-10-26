package com.huh.demo.volatileTest;

public class Seg implements Runnable {

    private volatile int[] tabs = new int[10];

    public void setValue(int index) {
        tabs[index] = 2;
    }

    public Object getValue(int index) {
        return tabs[index];
    }



    public static  void main(String [] args){
        Seg seg = new Seg();
        Thread thread1 = new Thread(seg);
        Thread thread2 = new Thread(seg);

    }

    @Override
    public void run() {
        this.setValue(2);
    }
}