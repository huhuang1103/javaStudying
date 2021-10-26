package com.huh.demo.volatileTest;

public class TestVolatitleList implements Runnable{
    private volatile  int [] a ={1,2,3};

    public static  void  main(String[] args){


    }

    @Override
    public void run() {

    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }
}
